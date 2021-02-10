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
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    private String password;

    @ManyToMany
    private List<AuthoritiesEntity> role;


}
