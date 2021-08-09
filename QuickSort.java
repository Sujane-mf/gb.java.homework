package ru.geekbrains.alg_hw5;

import java.util.ArrayList;

public class QuickSort {
    public static ArrayList<Item> quickSort(ArrayList<Item> items){
        if (items.isEmpty()) {
            return items;
        }
        Item base = items.get(0);
        ArrayList<Item> left = new ArrayList<>();
        ArrayList<Item> middle = new ArrayList<>();
        ArrayList<Item> right = new ArrayList<>();

        for (Item n : items){
            if (n.equals(base)) {
                middle.add(n);
            } else if (n.cost > base.cost) {
                right.add(n);
            } else {left.add(n);};
        }
        left = quickSort(left);
        right = quickSort(right);

        left.addAll(middle);
        left.addAll(right);

        return left;
    }
    public static ArrayList<Item> sort(ArrayList<Item> items) {
        return quickSort(items);
    }
}
