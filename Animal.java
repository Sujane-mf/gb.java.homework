package ru.geekbrains.homework6;

public class Animal {
    String name;
    String color;
    float height;
    int length;

    Animal(String name, String color, float height, int length)
    {
        this.name = name;
        this.color = color;
        this.height = height;
        this.length = length;
    }
    public void run(){System.out.println("Животные бегают");}
    public void jump(){System.out.println("Животные прыгают");};
    public void swim(){System.out.println("Животные плавают");};
}
