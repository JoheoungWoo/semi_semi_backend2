package com.semi_semi_backend11.semisemi.repository;

import com.semi_semi_backend11.semisemi.entity.Question;
import com.semi_semi_backend11.semisemi.service.questions.QuestionsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface QuestionRepository extends JpaRepository<Question,Integer> {
    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.answer LEFT JOIN FETCH q.member")
    Optional<Question> findByIdWithAnswer(@Param("id") int id);

    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.answer") // 👈 q.member도 추가 (Member 매핑이 있다면)
    List<Question> findAllWithAnswer();
}
