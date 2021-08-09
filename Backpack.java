package ru.geekbrains.alg_hw5;

import java.util.ArrayList;

public class Backpack{
    int maxWeight;
    ArrayList<Item> items;
    ArrayList<Item> filledBp;


    public Backpack(int maxWeight, ArrayList<Item> items) {
        this.maxWeight = maxWeight;
        this.items = items;
        this.filledBp = new ArrayList<>();
    }


    public ArrayList<Item> fillBackpack(int mw, ArrayList<Item> items, int capacity){

        if (mw <= 0 || mw < items.get(capacity-1).weight || capacity == 0){
            return null;
        }else {
            mw = mw - items.get(capacity-1).weight;
            filledBp.add(items.get(capacity-1));
            capacity = capacity - 1;
            fillBackpack(mw, items, capacity);
        } return filledBp;
    }

}

