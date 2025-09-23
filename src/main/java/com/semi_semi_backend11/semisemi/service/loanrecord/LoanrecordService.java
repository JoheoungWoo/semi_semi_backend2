package com.semi_semi_backend11.semisemi.service.loanrecord;

import com.semi_semi_backend11.semisemi.dto.LoanRecordDto;

import java.util.List;
import java.util.Optional;

public interface LoanrecordService {
    List<LoanRecordDto> findAllLoanRecord();
    Optional<LoanRecordDto> findLoanRecord(Integer loanId);
}
