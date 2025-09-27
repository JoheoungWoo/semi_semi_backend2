package com.semi_semi_backend11.semisemi.controller.questions;

import com.semi_semi_backend11.semisemi.dto.QuestionDto;
import com.semi_semi_backend11.semisemi.service.questions.QuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(
        origins = "http://localhost:3000",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PATCH,RequestMethod.OPTIONS},
        allowedHeaders = "*")
public class QuestionsController {
    @Autowired

    private QuestionsService service;

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDto>> getAll(){
        List<QuestionDto> list = service.questions();
        if(list.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(list);
        }
    }
}
