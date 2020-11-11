package ru.geekbrains.j2_homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Server() {
        try {
            System.out.println("Сервер запущен");
            serverSocket = new ServerSocket(8888);
            System.out.println("Сервер ждет подключения");
            clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился" + clientSocket);
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            new Thread(()-> {
                try {
                    while (true) {
                        System.out.println("Введи сообщение с сервера");
                        out.writeUTF(sc.nextLine());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            while (true){
                String incomingMessage = in.readUTF();
                if(incomingMessage.contains("-exit")){
                    out.writeUTF("cmd Exit");
                    break;
                }
                System.out.println(incomingMessage);
                //out.writeUTF("Эхо..." + incomingMessage);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    private void closeConnection(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}
