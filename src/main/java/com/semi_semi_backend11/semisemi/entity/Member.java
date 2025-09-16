package com.semi_semi_backend11.semisemi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity

public class Member {
    @Id
    private Long member_id;
    private String name;
    private LocalDate birth_date;
    private String address;
    private String phone_number;
    private String email;
    private LocalDate join_date;
    private String grade;



}
