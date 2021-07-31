package ru.geekbrains.alg_hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Array {
    int size;
    public Array(int size) {
        this.size = size;
            }

    //генерим полный массив по условию: массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1)
    public Integer [] fillTheArray (int size){
        Integer[] arr = new Integer[size];
        arr[0] = 1;
        for (int i=1; i < size; i++){
            arr[i] = arr[i-1] + 1;
        }   return arr;
    }
    //генерим массив без одного рандомного элемента
    public Integer[] getFinalArray (Integer [] a){

        List<Integer> list = new ArrayList(Arrays.asList(a));
        Random generator = new Random();
        int randomIndex = generator.nextInt(a.length);
        list.remove(randomIndex);
        a = list.toArray(new Integer[list.size()]);
        return a;
        //System.out.println(Arrays.toString(a));
    }
}
