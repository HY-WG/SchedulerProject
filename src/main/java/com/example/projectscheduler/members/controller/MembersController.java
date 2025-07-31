package com.example.projectscheduler.members.controller;

import com.example.projectscheduler.members.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MembersController {
    private MemberService memberService;

    @PostMapping(/members)
    public ResponseEntity<MembersSaveResponseDto> saveMember(@RequestBody MemberSaveResponseDto responseDto) {
        return ResponseEntity.ok(memberService.saveMember(responseDto));

        @GetMapping("/members")
        public List<Members> getMembers() {
            return memberService.findAll();
    }

}
