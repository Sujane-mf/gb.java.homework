package ru.geekbrains.j3_homework5;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private float maxFuel = 200f;
    private float currentFuel = 200f;
    static ReadWriteLock lock = new ReentrantReadWriteLock();

    //для получения необходимого кол-ва топлива
    public boolean request(float amount){
    lock.writeLock().lock();
    if (amount <= currentFuel) {
        currentFuel = currentFuel - amount;
        System.out.println("После заправки осталось: " + currentFuel);
        lock.writeLock().unlock();
        return true;
    } else {
        System.out.println("На заправке не хватает топлива: " + currentFuel);
        lock.writeLock().unlock();
        return false;
    }
    }
    // метод для выведения информации о фактическом состоянии
    public float info(){
        lock.readLock().lock();
        System.out.println("На заправке осталось: " + currentFuel);
        lock.readLock().unlock();
        return currentFuel;
    }
}
