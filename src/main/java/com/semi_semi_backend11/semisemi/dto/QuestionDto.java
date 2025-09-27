package com.semi_semi_backend11.semisemi.dto;

import com.semi_semi_backend11.semisemi.entity.Answer;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDto {
    private Integer questionId;
    private Integer memberId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String answer;
    private String memberName;
}
