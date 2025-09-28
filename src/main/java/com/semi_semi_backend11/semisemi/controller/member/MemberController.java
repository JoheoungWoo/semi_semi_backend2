package com.semi_semi_backend11.semisemi.controller.member;
import com.semi_semi_backend11.semisemi.dto.MemberDto;
import com.semi_semi_backend11.semisemi.entity.Member;
import com.semi_semi_backend11.semisemi.service.member.MemberService;
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
public class MemberController {
    @Autowired
    private MemberService service;
    @GetMapping("/member/info/{id}")
    public ResponseEntity<MemberDto> getMemberInfo(@PathVariable("id") Long id){
        Optional<MemberDto> dto= service.getMemberInfo(id);
        if(dto.isPresent()){
            return ResponseEntity.ok(dto.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/members")
    public ResponseEntity<List<MemberDto>> getMemberList(){
        Optional<List<MemberDto>> list = service.getAllMember();
        if(list.isPresent()) return ResponseEntity.ok(list.get());
        else return ResponseEntity.notFound().build();
    }
}
