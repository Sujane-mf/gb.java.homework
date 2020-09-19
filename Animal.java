package ru.geekbrains.homework6;

public class Animal {
    String name;
    float jumpHeight;
    int runLength;
    int swimLength;
    int userRunLength;
    int userSwimLength;
    float userJumpHeight;

    Animal(String name, float jumpHeight, int runLength, int swimLength)
    {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
        this.swimLength = swimLength;
    }
    public void run(int userRunLength, int runLength)
    {
        if (userRunLength <= runLength){
        System.out.println(name + " пробежала " + userRunLength + " метров");
        } else {
        System.out.println(name + " так далеко не бегает");
        }
    }
    public void jump(float userJumpHeight, float jumpHeight) {
        if (userJumpHeight <= jumpHeight) {
            System.out.println(name + " подпрыгнула на " + userJumpHeight + " метров");
        } else {
            System.out.println(name + " так высоко не прыгает");
        }
    }
    public void swim(int userSwimLength, int swimLength)
    {
        if (userSwimLength <= swimLength){
            System.out.println(name + " проплыла " + userSwimLength + " метров");
        } else {
            System.out.println(name + " так далеко не плавает");
        }
    };
}
