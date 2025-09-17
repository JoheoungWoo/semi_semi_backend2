package com.semi_semi_backend11.semisemi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOAN_RECORDS")
public class LoanRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Integer loanId;
    @Column(name = "member_id")
    private Integer memberId;
    private String isbn;
    @Column(name = "loan_date")
    private LocalDate loanDate;
    @Column(name = "return_date")
    private LocalDate returnDate;
}
