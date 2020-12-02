package ru.geekbrains.j2_homework7.server;

import ru.geekbrains.j2_homework7.entity.User;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            doListen();
        } catch (IOException e) {
            throw new RuntimeException("Произошла ошибка", e);
        }
    }

    public String getName() {
        return name;
    }

    private void doListen(){
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
               try {
                   doAuth();
                   recieveMessage();
               }catch (Exception e){
                   throw new RuntimeException("Произошла ошибка",e);
               } finally {
                   server.unsubscribe(ClientHandler.this);
               }
            }
        });
        t1.start();
    }
    private void doAuth(){
        try {
            while (true) {
                String credentials = in.readUTF();
                // образец ввода проверки: "-auth n1@mail.ru 1"
                if (credentials.startsWith("-auth")) {
                    String[] credentialsValues = credentials.split("\\s");
                    /*для разбития строки по пробелу, после сплита получаем массив вида:
                    values ["-auth", "n1@mail.ru", "1"]
                    */
                    //у меня отсутствует метод ifPresentOrElse, убрала все связанное с Optional
                    User mayBeUser = server.getAuthenticationService().doAuth(credentialsValues[1], credentialsValues[2]);
                    if (mayBeUser!= null){
                        if(!server.isLoggedIn(mayBeUser.getNickname())){
                            sendMessage("Аутентификация прошла успешно");
                            readLog(3);
                            name = mayBeUser.getNickname();
                            server.broadcastMessage(name + "залогинился");
                            server.subscribe(this);
                            break;
                        }
                        else {
                            sendMessage("Текущий пользователь уже залогинился");
                            break;
                        }
                    } else {
                       sendMessage("Не корректный логин или пароль");
                       break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Произошла ошибка", e);
        }
    }
    //получает сообщение от себя и направляет через сервер на всех
    private void recieveMessage(){
        try{
          while (true){
              String message = in.readUTF();
              server.chatLog(message);

              /* образец ввода личного сообщение: "/w u3 Привет"
              если сообщение содержит /w вызываем новый метод sendPrivateMessage,
               метож реализован в ChatServer, добавлен в интерфейс Server
              */
              if (message.startsWith("/w")){
                  String[] wordsForPrMessage = message.split("\\s");
                  String nickForReciever = wordsForPrMessage[1];
                  String privateMessage = wordsForPrMessage[2];
                  server.sendPrivateMessage(privateMessage,nickForReciever);
              } else server.broadcastMessage(message);
              if (message.equals("-exit")){
                  server.unsubscribe(this);
              }
              //server.broadcastMessage(message);
          }
        }catch (IOException e){
            throw new RuntimeException("Произошла ошибка", e);
        }
    }
    public void readLog(int count) {

        try {
            BufferedReader readChatHistory = new BufferedReader(
                    new FileReader(ChatServer.outputFileName)
            );

            String line;
            List<String> tempLine = new ArrayList<>();

            while((line = readChatHistory.readLine()) != null) {
                tempLine.add(line);
            }
            for (int i = tempLine.size()-1; i > tempLine.size() -1 - count; i--){
                //System.out.println(tempLine.get(i));
                sendMessage(tempLine.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String message){
        try {
            out.writeUTF(message);
            System.out.println(message);
        }catch (IOException e){
            throw new RuntimeException("Произошла ошибка", e);
        }
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return Objects.equals(server, that.server) &&
                Objects.equals(socket, that.socket) &&
                Objects.equals(in, that.in) &&
                Objects.equals(out, that.out) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, socket, in, out, name);
    }
}


