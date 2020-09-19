package ru.geekbrains.homework6;

public class Cat extends Animal {

     Cat(String name, float jumpHeight, int runLength, int swimLength)
    {
        super(name, jumpHeight, runLength, swimLength);
        }

    @Override
    public void swim(int userSwimLength, int swimLength)
        {
            System.out.println("кошки не плавают");
        }
    }