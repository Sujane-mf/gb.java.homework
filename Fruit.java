package ru.geekbrains.j3_homework1_fruits_and_boxes;

public abstract class Fruit {
    private float weight;


    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}
