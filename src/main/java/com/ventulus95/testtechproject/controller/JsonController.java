package com.ventulus95.testtechproject.controller;

import com.ventulus95.testtechproject.dto.request.JsonCommonTypeRequest;
import com.ventulus95.testtechproject.dto.request.NaverJsonTypeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class JsonController {

    @PostMapping("/test")
    public ResponseEntity<String> jsonTest(@RequestBody JsonCommonTypeRequest request) {
        log.info("request {}", getRequest(request));

        return ResponseEntity.ok("");
    }

    private static NaverJsonTypeRequest getRequest(JsonCommonTypeRequest request) {
        return (NaverJsonTypeRequest) request;
    }


}
