package com.ventulus95.testtechproject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventulus95.testtechproject.dto.PojoDefault;
import com.ventulus95.testtechproject.dto.PojoDefaultAbsent;
import com.ventulus95.testtechproject.dto.PojoDefaultEmpty;
import com.ventulus95.testtechproject.dto.PojoDefaultNon;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class JsonIncludeTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void 기본옵션_JsonInclude테스트() throws JSONException, JsonProcessingException {
        PojoDefault pojoDefault = PojoDefault.builder().build();
        prettyPrint(pojoDefault);
        JSONAssert.assertEquals("""
                {"string": null,"_long": null,"aboolean": null,"integer": null,"localDateTime":null}
                """, objectMapper.writeValueAsString(PojoDefault.builder().build()), true);
    }

    @Test
    void Non_Null_JsonInclude테스트() throws JSONException, JsonProcessingException {
        PojoDefault pojoDefault = PojoDefault.builder().build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        prettyPrint(pojoDefault);
        JSONAssert.assertEquals("""
                {}
                """, objectMapper.writeValueAsString(pojoDefault), true);
    }


    @Test
    void Non_Absent_JsonInclude테스트() throws JSONException, JsonProcessingException {
        PojoDefaultAbsent pojoDefault = PojoDefaultAbsent.builder().build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
        prettyPrint(pojoDefault);
        JSONAssert.assertEquals("""
                {}
                """, objectMapper.writeValueAsString(pojoDefault), true);
    }


    @Test
    void Non_Absent_JsonInclude테스트_optional이_null이_아닌경우() throws JSONException, JsonProcessingException {
        PojoDefaultAbsent pojoDefault = PojoDefaultAbsent.builder().stringOptional(Optional.ofNullable(null)).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
        prettyPrint(pojoDefault);
        JSONAssert.assertEquals("""
                {stringOptional: {} }
                """, objectMapper.writeValueAsString(pojoDefault), JSONCompareMode.LENIENT);
    }

    @Test
    void Non_Absent_JsonInclude테스트_atomic이_null이_아닌경우() throws JSONException, JsonProcessingException {
        PojoDefaultAbsent pojoDefault = PojoDefaultAbsent.builder().atomicInteger(new AtomicInteger()).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
        prettyPrint(pojoDefault);
        JSONAssert.assertEquals("""
                {atomicInteger: 0}
                """, objectMapper.writeValueAsString(pojoDefault), JSONCompareMode.LENIENT);
    }


    @Test
    void Non_Empty_JsonInclude테스트() throws JSONException, JsonProcessingException {
        PojoDefaultEmpty pojoDefaultEmpty = PojoDefaultEmpty.builder().build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        prettyPrint(pojoDefaultEmpty);
        JSONAssert.assertEquals("""
                {}
                """, objectMapper.writeValueAsString(pojoDefaultEmpty), JSONCompareMode.LENIENT);
    }

    @Test
    void Non_Empty_JsonInclude테스트_array안에_들어있는경우() throws JSONException, JsonProcessingException {
        PojoDefaultEmpty pojoDefaultEmpty = PojoDefaultEmpty.builder().array(new Integer[1]).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        prettyPrint(pojoDefaultEmpty);
        JSONAssert.assertEquals("""
                {}
                """, objectMapper.writeValueAsString(pojoDefaultEmpty), true);
    }


    @Test
    void Non_Default_JsonInclude테스트() throws JSONException, JsonProcessingException {
        PojoDefaultNon pojoDefaultEmpty = PojoDefaultNon.builder().string("").timestamp(new Timestamp(0L)).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        prettyPrint(pojoDefaultEmpty);
        System.out.println(pojoDefaultEmpty);
        JSONAssert.assertEquals("""
                {}
                """, objectMapper.writeValueAsString(pojoDefaultEmpty), JSONCompareMode.STRICT);
    }


    @Test
    void Non_Default_JsonInclude테스트_살짝_틀어보기() throws JSONException, JsonProcessingException {
        PojoDefaultNon pojoDefaultEmpty = PojoDefaultNon.builder().string(" ").timestamp(new Timestamp(1L)).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        prettyPrint(pojoDefaultEmpty);
        System.out.println(pojoDefaultEmpty);
        JSONAssert.assertEquals("""
                {}
                """, objectMapper.writeValueAsString(pojoDefaultEmpty), JSONCompareMode.STRICT);
    }

    @Test
    void Use_Default_JsonInclude테스트() throws JSONException, JsonProcessingException {
        PojoDefaultEmpty pojoDefaultEmpty = PojoDefaultEmpty.builder().list(new ArrayList<>()).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        prettyPrint(pojoDefaultEmpty);
        System.out.println(pojoDefaultEmpty);
        JSONAssert.assertEquals("""
                { "integer" : 0, "trueorFalse" : false, "list" : [ ]}
                """, objectMapper.writeValueAsString(pojoDefaultEmpty), JSONCompareMode.STRICT);
    }



    private void prettyPrint(Object o) throws JsonProcessingException {
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o));
    }

}
