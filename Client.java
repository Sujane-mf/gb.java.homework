package ru.geekbrains.file_storage.client;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Client {
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;

    public Client() throws IOException {
        socket = new Socket("localhost", 1235);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        runClient();
    }

    private void runClient() {
        JFrame frame = new JFrame("Cloud Storage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea ta = new JTextArea();
        // TODO: 02.03.2021
        // list file - JList
        DefaultListModel listModel = new DefaultListModel();
        JList list = new JList(listModel);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3, 5, 0));
        JButton uploadButton = new JButton("Upload");
        JButton downloadButton = new JButton("Download");
        JButton removeButton = new JButton("Remove");

        frame.getContentPane().add(BorderLayout.NORTH, ta);
        frame.getContentPane().add(BorderLayout.CENTER, list);
        frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.add(uploadButton);
        buttonsPanel.add(downloadButton);
        buttonsPanel.add(removeButton);
        frame.setVisible(true);

        uploadButton.addActionListener(a -> {
            System.out.println(sendFile(ta.getText()));
            listModel.addElement(ta.getText());
        });
        downloadButton.addActionListener(a ->{
            System.out.println(downloadFile(ta.getText()));
        });
        removeButton.addActionListener(a ->{
            System.out.println(removeFile(ta.getText()));
            listModel.removeElement(ta.getText());
        });
    }

    private String sendFile(String filename) {
        try {
            File file = new File("client" + File.separator + filename);
            if (file.exists()) {
                out.writeUTF("upload");
                out.writeUTF(filename);
                long length = file.length();
                out.writeLong(length);
                FileInputStream fis = new FileInputStream(file);
                int read = 0;
                byte[] buffer = new byte[256];
                while ((read = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                out.flush();
                String status = in.readUTF();
                return status;
            } else {
                return "File is not exists";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Something error";
    }
    //реализация метода для выгрузки файла
    private String downloadFile (String filename) {
        try {
            File file = new File("client" + File.separator + filename);
            out.writeUTF("download");
            out.writeUTF(filename);
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
            String status = in.readUTF();
            return status;
        } catch (IOException e) {
            e.printStackTrace();
        }
            return "Something error";
    }



    //реализация метода для удаления файла
    private String removeFile (String filename){
    try{
        File file = new File("server" + File.separator + filename);
            if (file.exists()) {
                out.writeUTF("remove");
                out.writeUTF(filename);
                out.flush();
                String status = in.readUTF();
                return status;
            } else {
                return "File is not exists";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Something error";
    }


    public static void main(String[] args) throws IOException {
        new Client();
    }
}

