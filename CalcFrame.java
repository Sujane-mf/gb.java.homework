package ru.geekbrains.homework8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame
{
public CalcFrame()
    {
    setTitle("Калькулятор");
    setBounds(300,300,300,450);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    JTextArea result = new JTextArea();
    result.setPreferredSize(new Dimension(300,40));
    add (result, BorderLayout.NORTH);
    JPanel numbers = new JPanel();
    add (numbers);
    numbers.setLayout(new GridLayout(4, 4));
    JButton[] buttons = new JButton[16];
    buttons[0] = new JButton("7");
    buttons[0].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            result.setText(result.getText() + 7);
        }
    });
        buttons[1] = new JButton("8");
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + 8);
            }
        });
        buttons[2] = new JButton("9");
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + 9);
            }
        });
        buttons[3] = new JButton("*");
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + "*");
            }
        });
        buttons[4] = new JButton("4");
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + 4);
            }
        });
        buttons[5] = new JButton("5");
        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + 5);
            }
        });
        buttons[6] = new JButton("6");
        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + 6);
            }
        });
        buttons[7] = new JButton("-");
        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + "-");
            }
        });
        buttons[8] = new JButton("1");
        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + 1);
            }
        });
        buttons[9] = new JButton("2");
        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + 2);
            }
        });
        buttons[10] = new JButton("3");
        buttons[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + 3);
            }
        });
        buttons[11] = new JButton("+");
        buttons[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + "+");
            }
        });
        buttons[12] = new JButton("0");
        buttons[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + 0);
            }
        });
        buttons[13] = new JButton("C");
        buttons[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(" ");
            }
        });
        buttons[14] = new JButton("/");
        buttons[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(result.getText() + "/");
            }
        });
        buttons[15] = new JButton("=");
        buttons[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultSt = result.getText();
                try {
                    Calculation (resultSt);
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
                try {
                    System.out.println(Calculation(resultSt).doubleValue());
                    result.setText(String.valueOf(Calculation(resultSt).doubleValue()));
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
            }
        });
        numbers.add (buttons[0]);
        numbers.add (buttons[1]);
        numbers.add (buttons[2]);
        numbers.add (buttons[3]);
        numbers.add (buttons[4]);
        numbers.add (buttons[5]);
        numbers.add (buttons[6]);
        numbers.add (buttons[7]);
        numbers.add (buttons[8]);
        numbers.add (buttons[9]);
        numbers.add (buttons[10]);
        numbers.add (buttons[11]);
        numbers.add (buttons[12]);
        numbers.add (buttons[13]);
        numbers.add (buttons[14]);
        numbers.add (buttons[15]);
    setVisible(true);
    }
            public  Number Calculation(String input) throws ScriptException {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            return (Number) engine.eval(input);
}

    }

