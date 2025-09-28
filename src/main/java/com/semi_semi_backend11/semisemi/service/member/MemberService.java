package com.semi_semi_backend11.semisemi.service.member;

import com.semi_semi_backend11.semisemi.dto.MemberDto;
import com.semi_semi_backend11.semisemi.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Optional<MemberDto> getMemberInfo(Long id);
    void updateMemberInfo(Member member);
    Optional<List<MemberDto>> getAllMember();


}
