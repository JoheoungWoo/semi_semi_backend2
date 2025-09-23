package com.semi_semi_backend11.semisemi.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRecordDto {
    private Integer loanId;
    private Integer memberId;
    private String isbn;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
