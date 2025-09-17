package com.semi_semi_backend11.semisemi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaqDto {
    private Integer faqId;
    private String category;
    private String question;
    private String answer;
}
