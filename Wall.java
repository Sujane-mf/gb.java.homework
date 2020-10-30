package ru.geekbrains.j2_homework1;

public class Wall implements Obstacle{
    public int size;
    public Wall(int size){
        this.size = size;
    }
    public boolean overcomeTheObstacle(Action act) {
        System.out.println("Перепрыгни стену высотой " + size);
        return act.jump(getSize());
    }

    @Override
    public int getSize() {
        return size;
    }
}
