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
public class LoanRecordDto {
    private Integer loanId;
    private Integer memberId;
    private String isbn;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
