package ru.geekbrains.j2_homework1;

public class Treadmill implements Obstacle {
    private int size;
    public Treadmill(int size){
        this.size = size;
    }
    public boolean overcomeTheObstacle(Action act) {
        System.out.println("Преодолей беговую дорожку длинной " + size);
        return act.run(getSize());
    }

    @Override
    public int getSize() {
        return size;
    }
}
