package ru.geekbrains.homework6;

public class Cat extends Animal {

    int restForRun = 200;
    float restForJump = 2f;
    int restForSwim = 0;
    int userLength;
    float userHeight;

    Cat(String name, String color, float height, int length) {
        super(name, color, height, length);
    }

    public void run(int userLength){
        if (userLength <= restForRun){
            System.out.println("кошка пробежала" + userLength + " метров");
        } else {
            System.out.println("кошка так далеко не бегает");
        }
    }

    public void jump(float userHeight){
        if (userHeight <= restForJump){
            System.out.println("кошка подпрыгнула на " + userHeight + " метров");
        } else {
            System.out.println("кошка так высоко не прыгает");
        }
    }

    public void swim()
        {
            System.out.println("кошки не плавают");
        }
    }