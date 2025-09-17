package com.semi_semi_backend11.semisemi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Integer questionId;
    private Integer memberId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
