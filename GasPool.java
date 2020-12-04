package ru.geekbrains.j3_homework5;

public class GasPool {
    private float maxFuel = 200f;
    private float currentFuel = 200f;
    //для получения необходимого кол-ва топлива
    public synchronized boolean request(float amount){

    if (amount <= currentFuel) {
        currentFuel = currentFuel - amount;
        System.out.println("После заправки осталось: " + currentFuel);
        return true;
    } else {
        System.out.println("На заправке не хватает топлива: " + currentFuel);
        return false;
    }
    }
    // метод для выведения информации о фактическом состоянии
    public float info(){
        System.out.println("На заправке осталось: " + currentFuel);
        return currentFuel;
    }
}
