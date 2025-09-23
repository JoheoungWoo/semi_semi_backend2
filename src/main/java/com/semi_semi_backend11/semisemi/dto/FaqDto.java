package com.semi_semi_backend11.semisemi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FaqDto {
    private Integer faqId;
    private String category;
    private String question;
    private String answer;
}
