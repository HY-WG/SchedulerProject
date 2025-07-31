package com.example.projectscheduler.members.controller;

import com.example.projectscheduler.members.dto.MemberSaveRequestDto;
import com.example.projectscheduler.members.dto.MemberSaveResponseDto;
import com.example.projectscheduler.members.entity.Member;
import com.example.projectscheduler.members.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MembersController {
    private MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(@RequestBody MemberSaveRequestDto requestDto) {
        return ResponseEntity.ok(memberService.saveMember(requestDto));
    }
        @GetMapping("/members")
        public List<Member> getMembers() {
            return memberService.findAll();
    }
    }


