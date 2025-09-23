package com.semi_semi_backend11.semisemi.repository;

import com.semi_semi_backend11.semisemi.entity.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRecordRepository extends JpaRepository<LoanRecord, Integer> {
}
