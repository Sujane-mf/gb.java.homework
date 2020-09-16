package ru.geekbrains.homework6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введи высоту препятствия");
        float userHeigth = sc.nextFloat();
        System.out.println("введи длину препятствия");
        int userLength = sc.nextInt();
	Dog dog1 = new Dog ("Busya", "black", userHeigth, userLength);
	System.out.println("Собака " + dog1.name + " цвета "+ dog1.color + " выполни команды на заданную величину");
	dog1.run(userLength);
	dog1.jump(userHeigth);
	dog1.swim(userLength);
	Cat cat1 = new Cat("Koshka", "white", userHeigth, userLength);
        System.out.println("Кошка " + cat1.name + " цвета "+ cat1.color + " выполни команды на заданную величину");
        cat1.run(userLength);
        cat1.jump(userHeigth);
        cat1.swim();
	    }
}
