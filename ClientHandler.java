package ru.geekbrains.file_storage.server;

import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;

/**
 * Обработчик входящих клиентов
 */
public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())){
            while (true) {
                String command = in.readUTF();
                if ("upload".equals(command)) {
                    try {
                        File file = new File("server" + File.separator + in.readUTF());
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        long size = in.readLong();
                        FileOutputStream fos = new FileOutputStream(file);
                        byte[] buffer = new byte[256];
                        for (int i = 0; i < (size + 255) / 256; i++) {
                            int read = in.read(buffer);
                            fos.write(buffer, 0, read);
                        }
                        fos.close();
                        out.writeUTF("DONE");
                    } catch (Exception e) {
                        out.writeUTF("ERROR");
                    }
                } else if ("download".equals(command)) {
                    // TODO: 02.03.2021
                    // realize download
                    try {
                        File file = new File("server" + File.separator + in.readUTF());
                        if (file.exists()) {

                            long length = file.length();
                            out.writeLong(length);
                            FileInputStream fis = new FileInputStream(file);
                            int read = 0;
                            byte[] buffer = new byte[256];
                            while ((read = fis.read(buffer)) != -1) {
                                out.write(buffer, 0, read);
                            }

                            out.flush();

                        } else {
                            System.out.println("File is not exists");
                        }
                        out.writeUTF("DONE");
                    } catch (Exception e) {
                        out.writeUTF("ERROR");
                    }
                } else if ("remove".equals(command)) {
                    // TODO: 02.03.2021
                    // realize remove
                    try {
                        File file = new File("server" + File.separator + in.readUTF());
                        if (file.exists()) {
                            file.delete();
                        }
                    out.writeUTF("DONE");
                    } catch (Exception e) {
                        out.writeUTF("ERROR");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

