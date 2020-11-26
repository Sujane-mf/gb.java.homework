package ru.geekbrains.j2_homework7.entity;

import java.util.Optional;

public class User {
    private int object_id;
    private String nickname;
    private String email;
    private String password;


    public User(int object_id, String nickname, String email, String password) {
        this.object_id = object_id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public int getObject_id() {
        return object_id;
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

    @Override
    public String toString() {
        return "User{" +
                "object_id=" + object_id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
