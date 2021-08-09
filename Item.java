package ru.geekbrains.alg_hw5;

public class Item {
    String name;
    int cost;
    int weight;


    public Item(String name, int cost, int weight) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Предмет{" +
                "Наименование: " + name +
                ", Цена: " + cost +
                ", Вес: " + weight +
                '}';
    }
}
