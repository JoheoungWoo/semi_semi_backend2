package com.semi_semi_backend11.semisemi.repository;

import com.semi_semi_backend11.semisemi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
