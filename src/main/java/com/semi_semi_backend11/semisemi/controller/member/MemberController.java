package com.semi_semi_backend11.semisemi.controller.member;
import com.semi_semi_backend11.semisemi.dto.MemberDto;
import com.semi_semi_backend11.semisemi.entity.Member;
import com.semi_semi_backend11.semisemi.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin(
        origins = "http://localhost:3000",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PATCH,RequestMethod.OPTIONS},
        allowedHeaders = "*",
        allowCredentials = "true")
public class MemberController {
    @Autowired
    private MemberService service;
    @GetMapping("/member/info/{email}")
    public ResponseEntity<MemberDto> getMemberInfo(@PathVariable("email") String email){
        Optional<MemberDto> dto= service.getMemberInfo(email);
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

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto dto){
        boolean loginSuccess = service.login(dto.getEmail(), dto.getName());
        if(loginSuccess) {
            Map<String, Object> responseBody= new HashMap<>();
            responseBody.put("success",true);
            responseBody.put("message","로그인 성공");
            return ResponseEntity.ok(responseBody);
        }else{
            Map<String, Object> responseBody= new HashMap<>();
            responseBody.put("success",false);
            responseBody.put("message","이메일 또는 이름을 확인해주세요.");
            return ResponseEntity.ok(responseBody);
        }

    }
}
