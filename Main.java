package ru.geekbrains.homework3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поиграем в игру Угадайка. У вас будет 3 попытки");
        playGame();
    }
    public static void playGame(){
        Random random = new Random();
        int riddle = random.nextInt(10);
        System.out.println("Загаданное число: " + riddle);
        guessTheNumber(riddle);
    }
    public static void guessTheNumber(int riddle) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 4; i++) {
            System.out.println("Угадайте число, это ваша попытка № " + i);
            System.out.println("Введите число");
            int number = scanner.nextInt();
            if (number == riddle) {
                System.out.println("Вы угадали");
                int answer = getAnswer();
                if (answer == 0) {
                    break;
                } else {
                    playGame();
                }
            } else if (number > riddle) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше");
            }
            if (i == 3) {
                System.out.println("Вы не угадали, Ваши попытки закончились, загаданное число: "+riddle);
                int answer = getAnswer();
                if (answer == 1) {
                    playGame();
                } break;


            }
        }
    }
public static int getAnswer (){
Scanner scanner = new Scanner(System.in);
System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
int ans = scanner.nextInt();
    if (ans == 1) {
        return 1;
    } else {
        return 0;
    }
}
}

