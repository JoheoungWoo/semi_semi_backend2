package com.semi_semi_backend11.semisemi;

import com.semi_semi_backend11.semisemi.entity.Answer;
import com.semi_semi_backend11.semisemi.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Transactional
@SpringBootTest
public class QuestionAnswerTest {
    @Autowired
    QuestionRepository repository;

    @Test
    public void test(){
        var result=repository.findByIdWithAnswer(1);
        result.ifPresent(i->{
            System.out.println("질문 제목: "+i.getTitle()+"\n 질문 내용: "+i.getContent());
            if(i.getAnswer()!=null){
                System.out.println("답변: "+i.getAnswer().getContent());
            }else {
                System.out.println("답변이 작성되지 않았습니다.");
            }
        });
    }
}
