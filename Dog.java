package ru.geekbrains.homework6;

import java.util.Scanner;

public class Dog extends Animal {
    Scanner sc = new Scanner(System.in);
    int restForRun = 500;
    float restForJump = 0.5f;
    int restForSwim = 10;
    int userLength;
    float userHeight;

    Dog(String name, String color, float height, int length) {
        super(name, color, height, length);
    }

    public void run(int userLength){
              if (userLength <= restForRun){
            System.out.println("собака пробежала " + userLength + " метров");
        } else {
            System.out.println("собака так далеко не бегает");
        }
    }

    public void jump(float userHeight){
              if (userHeight <= restForJump){
            System.out.println("собака подпрыгнула на " + userHeight + " метров");
        } else {
            System.out.println("собака так высоко не прыгает");
        }
    }

    public void swim(int userLength){
            if (userLength <= restForSwim){
            System.out.println("собака проплыла" + userLength + " метров");
        } else {
            System.out.println("собака так далеко не плавает");
        }
    }
}