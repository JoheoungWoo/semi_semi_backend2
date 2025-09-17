package com.semi_semi_backend11.semisemi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ANSWERS")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer answerId;
    @Column(name = "question_id")
    private Integer questionId;
    @Column(name = "member_id")
    private Integer memberId;
    private String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
