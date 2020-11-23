package ru.geekbrains.j3_homework1_fruits_and_boxes;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;
    private float weight = 0;

    public Box() {
        fruits = new ArrayList<>();
    }

public void add(T fruit){
        fruits.add(fruit);
}

//public float getWeight(Fruit f){
//        weight = fruits.size() * f.getWeight();
//  return weight;
//}

 public float getWeight() {
        for (Fruit f : fruits){
            weight += f.getWeight();
        }
        return weight;
 }
public void moveTo(Box<T> newBox){
    fruits.forEach(fruit -> newBox.add(fruit));
    fruits.removeAll(fruits);
    weight = 0;
    newBox.weight = getWeight();
}

public boolean compare(Box<? extends Fruit> otherBox){
    return otherBox.getWeight() == getWeight();
}

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                ", weight=" + weight +
                '}';
    }
}
