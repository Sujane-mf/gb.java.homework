package ru.geekbrains.j2_homework7.auth;

import ru.geekbrains.j2_homework7.DBService;
import ru.geekbrains.j2_homework7.entity.User;
import ru.geekbrains.j2_homework7.entity.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasicAuthenticationService implements AuthenticationService, UserService {
    //наполняем БД network_chat таблицу user нашими пользователями;
    public static void main(String[] args) {
        BasicAuthenticationService bas = new BasicAuthenticationService();
        bas.addAndSave(new User(1,"u1", "u1@mail.ru", "1"));
        bas.addAndSave(new User(2,"u2", "u2@mail.ru", "2"));
        bas.addAndSave(new User(3,"u3", "u3@mail.ru", "3"));
        System.out.println(bas.findAll());
    }
        private static final List<User> users = new ArrayList<>();
//    //метод List.of отсутствует, мог ли он появится позже java8? заменила добабвлением через метод .add
//    static {
//        users.add(new User(0,"u1", "u1@mail.ru", "1"));
//        users.add(new User(1,"u2", "u2@mail.ru", "2"));
//        users.add(new User(2,"u3", "u3@mail.ru", "3"));
//
//    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Connection connection = DBService.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user WHERE email = ? AND password = ?"
            );
            {
            statement.setString(1, email);
            statement.setString(2, password);
            }
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("object_id"),
                        resultSet.getString("nickname"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }
            return null;
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during Fruit find by id", throwables);
        } finally {
            DBService.close(connection);
        }

    }

    @Override
    public int addAndSave(User user) {
        Connection connection = DBService.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO user (nickname, email, password) VALUES (?, ?, ?)"
            );{
               statement.setString(1, user.getNickname());
               statement.setString(2, user.getEmail());
               statement.setString(3,user.getPassword());
            }

            int val = statement.executeUpdate();

            connection.commit();
            return val;
        } catch (SQLException throwables) {
            DBService.rollback(connection);
            throw new RuntimeException("SWW during User save", throwables);
        } finally {
            DBService.close(connection);
        }
    }



    @Override
    public List<User> findAll() {
        Connection connection = DBService.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getInt("object_id"),
                                resultSet.getString("nickname"),
                                resultSet.getString("email"),
                                resultSet.getString("password")
                        )
                );
            }
            return users;
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during Users find all", throwables);
        } finally {
            DBService.close(connection);
        }

    }

    @Override
    /*реализуем интерфейс AuthenticationService:
     сверяем входящие параметры email и password с соответствующими полями имеющихся
     экземпляров класса User, добавленных в нашу фейковую БД List. Поля приватные, добираемся через геттер.
     * */
    public User doAuth(String email, String password) {
        if (findByEmailAndPassword(email,password)!= null) {
            return findByEmailAndPassword(email,password);
        } else return null;

//        for (User user: users){
//            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
//
//                return user;
//
//            }
//        }
//        return null;
    }


}


