package com.semi_semi_backend11.semisemi.service.seat;

import com.semi_semi_backend11.semisemi.dto.LoanRecordDto;
import com.semi_semi_backend11.semisemi.dto.SeatDto;
import com.semi_semi_backend11.semisemi.entity.LoanRecord;
import com.semi_semi_backend11.semisemi.entity.Seat;
import com.semi_semi_backend11.semisemi.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository repository;

    public SeatDto toDto(Seat seat){
        return SeatDto.builder()
                .seatNumber(seat.getSeatNumber())
                .memberId(seat.getMemberId())
                .seatStatus(seat.getSeatStatus())
                .build();
    }
    public Seat toEntity(SeatDto dto){
        return Seat.builder()
                .seatNumber(dto.getSeatNumber())
                .memberId(dto.getMemberId())
                .seatStatus(dto.getSeatStatus())
                .build();
    }

    @Override
    public List<SeatDto> findAllSeat() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Optional<SeatDto> findSeat(String seatNumber) {
        return repository.findById(seatNumber).map(this::toDto);
    }
}
