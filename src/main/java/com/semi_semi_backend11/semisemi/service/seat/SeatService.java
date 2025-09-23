package com.semi_semi_backend11.semisemi.service.seat;

import com.semi_semi_backend11.semisemi.dto.SeatDto;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    List<SeatDto> findAllSeat();
    Optional<SeatDto> findSeat(String seatNumber);
}
