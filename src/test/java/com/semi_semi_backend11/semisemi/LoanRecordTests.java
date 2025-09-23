package com.semi_semi_backend11.semisemi;


import com.semi_semi_backend11.semisemi.service.loanrecord.LoanrecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoanRecordTests {
    @Autowired
    LoanrecordService service;

    @Test
    public void findAllTest() {
        service.findAllLoanRecord()
                .forEach(record -> System.out.println(record));
    }
    
    @Test
    public void findByIdTest() {
        var result = service.findLoanRecord(1);
        if(result.isEmpty()){
            System.out.println("실패");
            return;
        }

        System.out.println(result.get());
    }
}
