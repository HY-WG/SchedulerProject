package com.example.projectscheduler.members.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Members {

    @Id @GeneratatedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Password;

    public Members(String name) {
        this.name = name;
    }
}
