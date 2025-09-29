package com.semi_semi_backend11.semisemi.repository;

import com.semi_semi_backend11.semisemi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
}
