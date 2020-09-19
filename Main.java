package ru.geekbrains.homework6;
/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
или высоту (для прыжков).
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
(Например, dog1.run(150); -> результат: run: true)
*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введи высоту препятствия");
        float userJumpHeigth = sc.nextFloat();
        System.out.println("введи длину забега");
        int userRunLength = sc.nextInt();
        System.out.println("введи длину заплыва");
        int userSwimLength = sc.nextInt();
    Dog dog1 = new Dog("Busya", 0.5f, 500, 10);
        System.out.println("Собака " + dog1.name + " выполни команды на заданную величину");
        dog1.run(userRunLength, dog1.runLength);
        dog1.jump(userJumpHeigth, dog1.jumpHeight);
        dog1.swim(userSwimLength, dog1.swimLength);
	Cat cat1 = new Cat("Koshka", 2, 200, 0);
        System.out.println("Кошка " + cat1.name + " выполни команды на заданную величину");
        cat1.run(userRunLength, cat1.runLength);
        cat1.jump(userJumpHeigth, cat1.jumpHeight);
        cat1.swim(userSwimLength, cat1.swimLength);
	    }
    }
