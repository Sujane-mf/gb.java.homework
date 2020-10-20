package ru.geekbrains.j2_homework1;

public class Treadmill implements Obstacle {
    public int size;
    public Treadmill(int size){
        this.size = size;
    }
    public void overcomeTheObstacle() {
        System.out.println("Преодолей беговую дорожку длинной " + size);
    }

}
