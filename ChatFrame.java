package ru.geekbrains.j2_homework4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatFrame extends JFrame{
    public ChatFrame(){
        setTitle("Network chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(700,300,400, 600);
        setLayout(null);
        JTextArea message = new JTextArea();
        message.setBounds(2,480,305,70);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        JButton send = new JButton("Send");
        send.setBounds(310,480,70,70);
        JTextArea result = new JTextArea();
        result.setBounds(2,2, 377,470);
        result.setLineWrap(true);
        result.setWrapStyleWord(true);
        add(message);
        add(send);
        add(result);
        send.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                result.append(message.getText() + "\n");
                message.selectAll();
                message.replaceSelection("");

            }
        });
        message.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    result.append(message.getText() + "\n");
                    message.selectAll();
                    message.replaceSelection("");
                }
            }
        });
        setVisible(true);
    }

}
