package com.dreamteam.motywatory.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "authorities")
public class AuthoritiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum ROLE{
        ADMIN,
        USER;
    }

    @ManyToMany
    private List<UserEntity> users;
}
