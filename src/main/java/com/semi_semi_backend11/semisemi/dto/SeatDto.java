package com.semi_semi_backend11.semisemi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDto {
    private String seatNumber;
    private Integer memberId;
    private String seatStatus;
}
