package com.semi_semi_backend11.semisemi.controller.FAQ;

import com.semi_semi_backend11.semisemi.dto.FaqDto;
import com.semi_semi_backend11.semisemi.service.FAQ.FaqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(
        origins = "http://localhost:3000",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PATCH,RequestMethod.OPTIONS},
        allowedHeaders = "*")
public class FaqController {
    @Autowired
    private FaqService service;

    @GetMapping("/FAQ")
    public ResponseEntity<Optional<Map<String, List<FaqDto>>>> getFaq(){
        Optional<Map<String, List<FaqDto>>> groupedFaq= service.getFaq();
        if(groupedFaq.isPresent()) {
            return ResponseEntity.ok(groupedFaq);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
