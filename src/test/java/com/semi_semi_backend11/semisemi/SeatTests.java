package com.semi_semi_backend11.semisemi;

import com.semi_semi_backend11.semisemi.service.seat.SeatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeatTests {
    @Autowired
    SeatService service;

    @Test
    public void findAllTest() {
        service.findAllSeat()
                .forEach(seat -> System.out.println(seat));
    }

    @Test
    public void findByIdTest() {
        var result = service.findSeat("A1");
        if(result.isEmpty()){
            System.out.println("실패");
            return;
        }

        System.out.println(result.get());
    }
}
