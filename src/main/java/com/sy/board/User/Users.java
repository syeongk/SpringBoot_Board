package com.sy.board.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="users_id")
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique=true)
    private String email;
}
