package com.example.projectscheduler.members.service;

import com.example.projectscheduler.members.dto.MemberSaveRequestDto;
import com.example.projectscheduler.members.dto.MemberSaveResponseDto;
import com.example.projectscheduler.members.entity.Member;
import com.example.projectscheduler.members.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {
        Member newMember = new Member(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
        Member savedMember = repository.save(newMember);

        return new MemberSaveResponseDto(savedMember.getName(), savedMember.getEmail());
    }

    public List<Member> findAll() {
    }
}
