package ru.geekbrains.j3_homework4;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new PrintABC('A', 'B'));
        executorService.submit(new PrintABC('B', 'C'));
        executorService.submit(new PrintABC('C', 'A'));
        executorService.shutdown();
    }
}
