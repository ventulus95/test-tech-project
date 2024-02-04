package com.ventulus95.testtechproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Builder
@Getter
public class PojoDefaultEmpty {

    private String string;
    private Map map;
    private Integer[] array;
    private int integer;
    private boolean trueorFalse;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> list;


//    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public List<String> getList() {
        return list;
    }
}
