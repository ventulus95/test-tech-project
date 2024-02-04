package com.ventulus95.testtechproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@ToString
public class PojoDefaultNon {

    private String string;
    private int integer;
    private boolean trueorFalse;
    private Timestamp timestamp;
    private char aChar;
    private float aFloat;

}
