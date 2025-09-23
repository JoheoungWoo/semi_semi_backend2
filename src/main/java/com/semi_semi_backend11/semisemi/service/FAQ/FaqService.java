package com.semi_semi_backend11.semisemi.service.FAQ;

import com.semi_semi_backend11.semisemi.dto.FaqDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FaqService {
    Optional<Map<String, List<FaqDto>>> getFaq();
}
