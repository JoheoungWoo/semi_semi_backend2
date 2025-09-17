package com.semi_semi_backend11.semisemi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDto {
    private Integer recommendId;
    private String isbn;
    private LocalDate recommendDate;
}