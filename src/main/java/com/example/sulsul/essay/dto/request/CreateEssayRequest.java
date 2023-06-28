package com.example.sulsul.essay.dto.request;

import com.example.sulsul.essay.entity.Essay;
import com.example.sulsul.essay.entity.type.EssayState;
import com.example.sulsul.essay.entity.type.ReviewState;
import com.example.sulsul.user.entity.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class CreateEssayRequest {
    @NotBlank
    @Size(min = 2, max = 20, message = "대학이름은 2글자 이상 20글자 이하입니다.")
    private String univ;

    @NotBlank
    @Size(min = 2, max = 8, message = "시험년도는 2글자 이상 8글자 이하입니다.")
    private String examYear;

    @NotBlank
    @Size(min = 2, max = 8, message = "논술분야는 2글자 이상 8글자 이하입니다.")
    private String eType;

    @NotBlank
    @Size(min = 2, max = 200, message = "문의사항은 2글자 이상 200글자 이하입니다.")
    private String inquiry;

    private MultipartFile essayFile; // 첨삭파일

    public Essay toEntity(User student, User teacher) {
        return Essay.builder()
                .univ(univ)
                .examYear(examYear)
                .eType(eType)
                .inquiry(inquiry)
                .essayState(EssayState.REQUEST)
                .reviewState(ReviewState.OFF)
                .student(student)
                .teacher(teacher)
                .build();
    }
}