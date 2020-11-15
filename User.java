package ru.geekbrains.j2_homework7.entity;

import java.util.Optional;

public class User {
    private String nickname;
    private String email;
    private String password;


    public User(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
