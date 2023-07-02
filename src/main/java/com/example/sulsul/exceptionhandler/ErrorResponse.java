package com.example.sulsul.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorResponse {

    private String code;

    private String messages;

    private Map<String, String> errors;

    @Builder
    public ErrorResponse(String code, String messages, Map<String, String> errors) {
        this.code= code;
        this.messages = messages;
        this.errors = errors;
    }

}