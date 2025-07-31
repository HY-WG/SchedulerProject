package com.example.projectscheduler.members.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSaveRequestDto {

    private String id;
    private String name;
    private String email;
    private String password;
}
