package com.ventulus95.testtechproject.dto.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class NaverJsonTypeRequest extends JsonCommonTypeRequest {

    private String naverId;
    private String blogInTitle;
}
