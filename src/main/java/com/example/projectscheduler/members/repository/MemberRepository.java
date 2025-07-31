package com.example.projectscheduler.members.repository;

import com.example.projectscheduler.members.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
