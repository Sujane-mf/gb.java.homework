package ru.geekbrains.j2_homework7.auth;

import ru.geekbrains.j2_homework7.entity.User;

public interface AuthenticationService {
    User doAuth(String login, String password); // если авторизация прошла возвращаем экземпляр класса User
}
