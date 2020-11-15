package ru.geekbrains.j2_homework7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 8888);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try{
                    while (true){
                        String message = in.readUTF();
                        System.out.println(message);
                    }
                }catch (IOException e){
                    throw new RuntimeException("Произошла ошибка", e);
                }
            }).start();
            Scanner sc = new Scanner(System.in);
            while (true){
                try {
                    System.out.println("Напиши что-нибудь");
                    out.writeUTF(sc.nextLine());
                }catch (IOException e){
                    throw new RuntimeException("Произошла ошибка", e);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    }

