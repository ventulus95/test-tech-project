package com.ventulus95.testtechproject.dto.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class KakaoJsonTypeRequest extends JsonCommonTypeRequest {

    private String kakaoId;
    private String messageTitle;
    private String blogInTitle;
    private List<String> friendIdList;
}
