package ru.geekbrains.homework1;

import java.util.Scanner;
// сама не поняла чего наподключала, но зато получилось считать строку
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


// 1. создаем первый класс и прописываем первый main руками
public class FirstApp {

    public static void main(String[] args) throws IOException{ // для чего конструкция с throws когда-нибудь я пойму
        Scanner scanner = new Scanner (System.in);
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        //2. объявляем переменные
        byte a;
        short b;
        int c;
        long d;
        float e;
        double f;
        char g;
        boolean h = true;
                //2. инициализируем переменные
        a = -127;
        b = 365;
        c = 563489;
        d = 1436478l;
        e = 14.25f;
        f = -120.35;
        g = 'r';
        solveTheCase (a,b,c,d); // вызываем метод для решения примера, на вход передаем объявленные ранее переменные
        whatIf(a,b); // вызываем метод для задания 4.
        System.out.println("Введите положительное или отрицательное число, на крайняк введите ноль");
        int i = scanner.nextInt ();
        positiveOrNot(i);
        onlyNegativeMatter(i,h);
        System.out.println("Введите имя");
        String name = reader.readLine();
        sayHi(name);
        System.out.println("Введите какой-нибудь год");
        int year = scanner.nextInt ();
        leapYears(year);
            }
    // 3. метод для решения примера
    static float solveTheCase(byte a, short b, int c, long d)
    {
        float Case = a * (b + (c/d));
        System.out.println("Решением примера является значение " + Case);
        return Case;
    }
    // задание 4. смотрим как работает if
    static void whatIf (byte a, short b)
    { int Sum = a+b;
    System.out.println("Входит ли наш Sum в диапазон?");
    if (10<=Sum && Sum <=20){
                System.out.println("А вот и да, сумма = " +Sum);
    }
                else {
        System.out.println("А вот и нет, сумма = " +Sum);
                }
        }
    // задание 5. положительное или отрицательное
    static void positiveOrNot (int i){
if (i < 0) {
    System.out.println("Введенное Вами число отрицательное, Вы ввели: " +i);
}else if (i == 0) {
    System.out.println("Введенное Вами число ноль, и мы считаем его пложительным: " +i);
}else {
    System.out.println("Введенное Вами число положительное, Вы ввели: " +i);
}

    }
    // задание 6. хорошо если отрицательно
    static boolean onlyNegativeMatter (int i, boolean h){

        if (i<0) {
            System.out.println("Введенное Вами число действительно отрицательное: " +h);
            }
        return h;

    }
    // задание 7. приветствие
    static void sayHi (String name){
        System.out.println("Привет, " + name);
    }
    // задание 8. високосный год всегда плохая идея
    static void leapYears (int year){
    if (year % 100 == 0 && year % 400 == 0) {
        System.out.println("Год високосный, т.к. является одним из 400-ых");

    } else {
        if (year % 4 == 0 && year % 100 != 0){
            System.out.println("Год високосный, т.к. не является одним из 100-х и делится на 4");
        }
        else {
            System.out.println("Остальные не високосные года");
        }
    }


    }
    }


