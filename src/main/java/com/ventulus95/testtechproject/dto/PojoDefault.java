package com.ventulus95.testtechproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PojoDefault {

    private String string;
    private Long _long;
    private Boolean aBoolean;
    private Integer integer;
    private LocalDateTime localDateTime;
}
