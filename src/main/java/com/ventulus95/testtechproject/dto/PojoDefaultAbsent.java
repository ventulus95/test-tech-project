package com.ventulus95.testtechproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Builder
@Getter
public class PojoDefaultAbsent {

    private String string;
    private Long _long;
    private Boolean aBoolean;
    private Integer integer;
    private LocalDateTime localDateTime;
    private Optional<String> stringOptional;
    private AtomicInteger atomicInteger;

}
