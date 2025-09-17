package com.semi_semi_backend11.semisemi.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.time.LocalDate;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class MemberDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;
    private String name;
    private LocalDate birth_date;
    private String address;
    private String phone_number;
    private String email;
    private LocalDate join_date;
    private String grade;



}
