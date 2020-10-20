package ru.geekbrains.j2_homework1;

public class Wall implements Obstacle{
    public int size;
    public Wall(int size){
        this.size = size;
    }
    public void overcomeTheObstacle() {
        System.out.println("Преодолей стену высотой " + size);
    }
}
