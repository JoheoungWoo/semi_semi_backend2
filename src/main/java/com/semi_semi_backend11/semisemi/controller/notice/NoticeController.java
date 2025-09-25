package com.semi_semi_backend11.semisemi.controller.notice;

import com.semi_semi_backend11.semisemi.dto.LoanRecordDto;
import com.semi_semi_backend11.semisemi.dto.NoticeDto;
import com.semi_semi_backend11.semisemi.service.notice.NoticeService;
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
public class NoticeController {
    @Autowired
    private NoticeService service;

    @GetMapping("/notice/list")
    public ResponseEntity<List<NoticeDto>> getNoticeInfoAll(){
        List<NoticeDto> dto= service.findAllNotice();
        if(dto.size() > 0){
            return ResponseEntity.ok(dto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/notice/info/{id}")
    public ResponseEntity<NoticeDto> getNoticeInfo(@PathVariable("id") Integer id) {
        Optional<NoticeDto> dto = service.findNotice(id);
        if (dto.isPresent()) {
            return ResponseEntity.ok(dto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
