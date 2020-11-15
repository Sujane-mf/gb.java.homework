package ru.geekbrains.j2_homework7.auth;

import ru.geekbrains.j2_homework7.entity.User;

import java.util.ArrayList;
import java.util.List;

public class BasicAuthenticationService implements AuthenticationService{
    //фейковая БД, содержащая наших пользователей
    private static final List<User> users = new ArrayList<>();
    //метод List.of отсутствует, мог ли он появится позже java8? заменила добабвлением через метод .add
    static {
        users.add(new User("u1", "u1@mail.ru", "1"));
        users.add(new User("u2", "u2@mail.ru", "2"));
        users.add(new User("u3", "u3@mail.ru", "3"));
    }

    @Override
    /*реализуем интерфейс AuthenticationService:
     сверяем входящие параметры email и password с соответствующими полями имеющихся
     экземпляров класса User, добавленных в нашу фейковую БД List. Поля приватные, добираемся через геттер.
     * */
    public User doAuth(String email, String password) {
        for (User user: users){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){

                return user;

            }
        }
        return null;
    }
}
