package com.semi_semi_backend11.semisemi.service.questions;

import com.semi_semi_backend11.semisemi.dto.QuestionDto;
import com.semi_semi_backend11.semisemi.entity.Question;
import com.semi_semi_backend11.semisemi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionsServiceImpl implements QuestionsService{
    @Autowired
    private QuestionRepository repository;
    public QuestionDto toDto(Question q){
        String answer = null;

        // 💡 2. Answer 엔티티 객체가 존재하는지 (null이 아닌지) 확인합니다.
        if (q.getAnswer() != null)
            // 답변이 있는 경우에만 내용을 추출합니다.
            answer = q.getAnswer().getContent();
        else answer = "아직 답변이 작성되지 않았습니다.";
        return QuestionDto.builder()
                .questionId(q.getQuestionId())
                .title(q.getTitle())
                .content(q.getContent())
                .createdAt(q.getCreatedAt())
                .memberId(q.getMemberId())
                .answer(answer)
                .memberName(q.getMember().getName())
                .build();

    }
    @Override
    public List<QuestionDto> questions() {
        List<QuestionDto> list = new ArrayList<>();
        repository.findAllWithAnswer().stream().forEach(i->
                list.add(toDto(i))
                );
        return list;
    }
}
