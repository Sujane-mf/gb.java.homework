package ru.geekbrains.j2_homework7.server;

import ru.geekbrains.j2_homework7.auth.AuthenticationService;
import ru.geekbrains.j2_homework7.auth.BasicAuthenticationService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer implements Server {
    private Set<ClientHandler> clients;
    private AuthenticationService authenticationService;

    public ChatServer() {
        try {
            System.out.println("Сервер стартует");
            ServerSocket serverSocket = new ServerSocket(8888);
            clients = new HashSet<>();
            authenticationService = new BasicAuthenticationService();
            System.out.println("Сервер стартовал");
            while (true){
                System.out.println("Сервер ждет клиента");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился к" + socket + "Ожидаю аутентификации");
                new ClientHandler(this, socket);

            }
        }
        catch (IOException e){
            throw new RuntimeException("SWW", e);
        }
    }

    @Override
    public synchronized void broadcastMessage(String message) {
        clients.forEach(client -> client.sendMessage(message));
    }
    //метод для рассылки сообщения только для клиента с именем соответствующем вытащенному нику из направленной строки
    @Override
    public synchronized void sendPrivateMessage(String message, String nick) {
        for (ClientHandler client : clients){
            if (client.getName().equals(nick)){
                client.sendMessage(message);

            }
        }
    }

    @Override
    public synchronized boolean isLoggedIn(String nickname) {
        return clients.stream()
                .filter(clientHandler -> clientHandler.getName().equals(nickname))
                .findFirst()
                .isPresent();
    }

    @Override
    public synchronized void subscribe(ClientHandler client) {
    clients.add(client);
    }

    @Override
    public synchronized void unsubscribe(ClientHandler client) {
    clients.remove(client);
    }

    @Override
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}
