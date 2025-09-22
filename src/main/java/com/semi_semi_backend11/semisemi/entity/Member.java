package com.semi_semi_backend11.semisemi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Member")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Member {
    @Id
    @Column(name = "member_id")
    private Long member_id;
    private String name;
    private LocalDate birth_date;
    private String address;
    private String phone_number;
    private String email;
    private LocalDate join_date;
    private String grade;



}
