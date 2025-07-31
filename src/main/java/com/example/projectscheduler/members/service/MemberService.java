package com.example.projectscheduler.members.service;

import com.example.projectscheduler.members.repository.MembersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MemberService {

    private final MembersRepository repository;

    @Transactional
    public MembersSaveResponseDto saveMember(MembersSaveResponseDto MembersSaveRequestDto) {
        Member newMember = new Member(memberSaveRequestDto.getName());
        Member savedMember = repository.save(newMember);

        return new MembersSaveResponseDto(savedMember.getName());

    }

    private MembersRepository membersRepository;
}
