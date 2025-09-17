package com.semi_semi_backend11.semisemi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SEATS")
public class Seat {
    @Id
    @Column(name = "seat_number")
    private String seatNumber;
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "seat_status")
    private String seatStatus;
}
