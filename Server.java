package ru.geekbrains.j2_homework7.server;

import ru.geekbrains.j2_homework7.auth.AuthenticationService;

public interface Server {
    void broadcastMessage(String message);// метод для рассылки сообщений
    void sendPrivateMessage(String message, String nick);//метод для рассылки приватного сообщения
    boolean isLoggedIn(String nickname);//проверяем на попытку логина под уже залогинившемся клиентом
    void subscribe(ClientHandler client);// подписаться
    void unsubscribe(ClientHandler client);//отписаться
    AuthenticationService getAuthenticationService();

}
