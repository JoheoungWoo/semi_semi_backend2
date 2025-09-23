package com.semi_semi_backend11.semisemi.controller.loanrecord;

import com.semi_semi_backend11.semisemi.dto.BookDto;
import com.semi_semi_backend11.semisemi.dto.LoanRecordDto;
import com.semi_semi_backend11.semisemi.dto.MemberDto;
import com.semi_semi_backend11.semisemi.service.loanrecord.LoanrecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(
        origins = "http://localhost:3000",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PATCH,RequestMethod.OPTIONS},
        allowedHeaders = "*")
public class LoanrecordController {
    @Autowired
    private LoanrecordService service;

    @GetMapping("/loanrecord/list")
    public ResponseEntity<List<LoanRecordDto>> getLoanrecordInfoAll(){
        List<LoanRecordDto> dto= service.findAllLoanRecord();
        if(dto.size() > 0){
            return ResponseEntity.ok(dto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/loanrecord/info/{id}")
    public ResponseEntity<LoanRecordDto> getLoanrecordInfo(@PathVariable("id") Integer id){
        Optional<LoanRecordDto> dto= service.findLoanRecord(id);
        if(dto.isPresent()){
            return ResponseEntity.ok(dto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
