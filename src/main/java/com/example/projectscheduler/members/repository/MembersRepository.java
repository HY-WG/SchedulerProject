package com.example.projectscheduler.members.repository;

import com.example.projectscheduler.members.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Long> {
}
