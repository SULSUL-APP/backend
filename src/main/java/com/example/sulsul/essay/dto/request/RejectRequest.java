package com.example.sulsul.essay.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@RequiredArgsConstructor
public class RejectRequest {
    @NotBlank
    @Size(min = 2, max = 20, message = "거절사유는 2글자 이상 20글자 이하입니다.")
    private final String rejectDetail;
}