package com.semi_semi_backend11.semisemi.controller.seat;

import com.semi_semi_backend11.semisemi.dto.NoticeDto;
import com.semi_semi_backend11.semisemi.dto.SeatDto;
import com.semi_semi_backend11.semisemi.service.seat.SeatService;
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
public class SeatController {
    @Autowired
    private SeatService service;

    @GetMapping("/seat/list")
    public ResponseEntity<List<SeatDto>> getSeatInfoAll(){
        List<SeatDto> dto= service.findAllSeat();
        if(dto.size() > 0){
            return ResponseEntity.ok(dto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/seat/info/{id}")
    public ResponseEntity<SeatDto> getSeatInfo(@PathVariable("id") String id){
        Optional<SeatDto> dto= service.findSeat(id);
        if(dto.isPresent()){
            return ResponseEntity.ok(dto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
