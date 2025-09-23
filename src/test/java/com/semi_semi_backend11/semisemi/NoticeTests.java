package com.semi_semi_backend11.semisemi;

import com.semi_semi_backend11.semisemi.service.notice.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoticeTests {
    @Autowired
    NoticeService service;

    @Test
    public void findAllTest() {
        service.findAllNotice()
                .forEach(notice -> System.out.println(notice));
    }

    @Test
    public void findByIdTest() {
        var result = service.findNotice(1);
        if(result.isEmpty()){
            System.out.println("실패");
            return;
        }

        System.out.println(result.get());
    }
}
