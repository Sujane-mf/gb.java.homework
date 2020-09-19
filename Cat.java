package ru.geekbrains.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    public boolean eat(Plate p) {
        //p.decreaseFood(appetite, fullness);
        fullness = p.decreaseFood(appetite, fullness);
        if (fullness == false){
            System.out.println("котик остался голодным, добавь еды в тарелку");
            return false;
        } else {
            System.out.println("котик покушал");
            return true;
        }
    }
}