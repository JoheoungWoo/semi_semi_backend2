package com.semi_semi_backend11.semisemi.service.member;

import com.semi_semi_backend11.semisemi.dto.MemberDto;
import com.semi_semi_backend11.semisemi.entity.Member;
import com.semi_semi_backend11.semisemi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository repository;

    public MemberDto toDto(Member member){
        return MemberDto.builder()
                .member_id(member.getMember_id())
                .grade(member.getGrade())
                .name(member.getName())
                .email(member.getEmail())
                .address(member.getAddress())
                .birth_date(member.getBirth_date())
                .join_date(member.getJoin_date())
                .phone_number(member.getPhone_number())
                .build();
    }
    public Member toEntity(MemberDto dto){
        return Member.builder()
                .member_id(dto.getMember_id())
                .grade(dto.getGrade())
                .name(dto.getName())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .birth_date(dto.getBirth_date())
                .join_date(dto.getJoin_date())
                .phone_number(dto.getPhone_number())
                .build();
    }

    @Override
    public Optional<MemberDto> getMemberInfo(Long id) {
        return repository.findById(id).map(i->toDto(i));
    }

    @Override
    public void updateMemberInfo(Member member) {

    }

    @Override
    public Optional<List<MemberDto>> getAllMember() {
        return Optional.of(repository.findAll().stream().map(this::toDto).toList());
    }


}
