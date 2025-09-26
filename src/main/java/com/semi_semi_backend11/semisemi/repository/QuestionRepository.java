package com.semi_semi_backend11.semisemi.repository;

import com.semi_semi_backend11.semisemi.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface QuestionRepository extends JpaRepository<Question,Integer> {
    @Query("SELECT q FROM Question q LEFT JOIN FETCH q.answer WHERE q.id = :id")
    Optional<Question> findByIdWithAnswer(@Param("id") int id);
}
