package com.semi_semi_backend11.semisemi.service.loanrecord;

import com.semi_semi_backend11.semisemi.dto.LoanRecordDto;
import com.semi_semi_backend11.semisemi.entity.LoanRecord;
import com.semi_semi_backend11.semisemi.repository.LoanRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanrecordServiceImpl implements LoanrecordService {
    private final LoanRecordRepository repository;

    public LoanRecordDto toDto(LoanRecord loanRecord){
        return LoanRecordDto.builder()
                .loanId(loanRecord.getLoanId())
                .memberId(loanRecord.getMemberId())
                .isbn(loanRecord.getIsbn())
                .loanDate(loanRecord.getLoanDate())
                .returnDate(loanRecord.getReturnDate())
                .build();
    }
    public LoanRecord toEntity(LoanRecordDto dto){
        return LoanRecord.builder()
                .loanId(dto.getLoanId())
                .memberId(dto.getMemberId())
                .isbn(dto.getIsbn())
                .loanDate(dto.getLoanDate())
                .returnDate(dto.getReturnDate())
                .build();
    }


    @Override
    public List<LoanRecordDto> findAllLoanRecord() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Optional<LoanRecordDto> findLoanRecord(Integer loanId) {
        return repository.findById(loanId).map(this::toDto);
    }
}
