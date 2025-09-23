package com.semi_semi_backend11.semisemi.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SEATS")
@Builder
public class Seat {
    @Id
    @Column(name = "seat_number")
    private String seatNumber;
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "seat_status")
    private String seatStatus;
}
