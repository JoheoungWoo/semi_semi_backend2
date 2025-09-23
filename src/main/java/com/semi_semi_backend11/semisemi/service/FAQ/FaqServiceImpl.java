package com.semi_semi_backend11.semisemi.service.FAQ;

import com.semi_semi_backend11.semisemi.dto.FaqDto;
import com.semi_semi_backend11.semisemi.entity.Faq;
import com.semi_semi_backend11.semisemi.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService{
    @Autowired
    private FaqRepository repository;
    public FaqDto toDto(Faq f){
        return FaqDto.builder()
                .faqId(f.getFaqId())
                .answer(f.getAnswer())
                .category(f.getCategory())
                .question(f.getQuestion())
                .build();
    }
    @Override
    public Optional<Map<String, List<FaqDto>>> getFaq() {
        List<Faq> faqList = repository.findAll();

        Map<String, List<FaqDto>> groupedFaq= faqList.stream()
                .map(faq->toDto(faq))
                .collect(Collectors.groupingBy(dto->dto.getCategory()));
        return Optional.of(groupedFaq);
    }
}
