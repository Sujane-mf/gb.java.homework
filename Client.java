package ru.geekbrains.j2_homework6;

import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    public Client() {
        try {
            System.out.println("Клиент запущен");
            socket = new Socket("localhost", 8888);
            System.out.println(socket);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            AtomicBoolean isDrop = new AtomicBoolean(false);
            new Thread(()-> {
                try {
                    while (true) {
                        String incomingMessage = in.readUTF();
                        if (incomingMessage.contains("cmd Exit")) {
                            System.out.println(incomingMessage);
                            System.out.println("Please press Enter to exit");
                            isDrop.set(true);
                            break;
                        }
                        System.out.println(incomingMessage);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            Scanner sc = new Scanner(System.in);
            while (true){
                if (isDrop.get()){
                    System.out.println("Closing...");
                    break;
                }
                System.out.println("Введи сообщение");
                out.writeUTF(sc.nextLine());
            }
            //System.out.println("Клиент отключился");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Client socket = new Client();
    }
}
