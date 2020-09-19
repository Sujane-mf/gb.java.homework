package ru.geekbrains.homework7;

public class Plate
{
    private int food;
    public Plate (int food)
    {
        this.food = food;
            }
    public boolean decreaseFood(int n, boolean f)
    {
        if (n > food){
            System.out.println("Тарелочки не хватит на аппетик котика");
            return false;
                                }
        else {
            System.out.println("Еды хватит, котик может покушать");
            food -= n;
            return true;
        }
    }
    public void addFood(int a)
    {
        food = food + a;
    }
    public void info () {
        System.out.println ("plate: " + food);
    }
}
