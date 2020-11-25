package ru.geekbrains.j2_homework7.entity;

import java.util.List;

public interface UserService {
    User findByEmailAndPassword (String email, String password);
    int addAndSave(User user);
    List<User> findAll();

}
