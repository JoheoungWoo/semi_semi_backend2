package com.semi_semi_backend11.semisemi.service.questions;

import com.semi_semi_backend11.semisemi.dto.QuestionDto;
import com.semi_semi_backend11.semisemi.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionsServiceImpl implements QuestionsService{
    private QuestionRepository repository;
    @Override
    public List<QuestionDto> questions() {
//        return repository.findAll().stream().toList();
        return null;
    }
}
