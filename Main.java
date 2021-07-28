package ru.geekbrains.alg_hw2;
//1. Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 5000 штук.
//   Условия для сортировки:
//   1) по цене. От 500 до 1000 долларов с шагом в 100
//   если цена равная, то
//   2) по кол-ву оперативной памяти (от 4 до 12 с шагом 4)
//   если памяти тоже равное количество, то 3) по производителю:
//   Lenuvo > Asos > MacNote > Eser > Xamiou

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final  int size = 5000;
        //тестовый прогон
        //final  int size = 10;
        Notebook[] arr =Notebook.getArray(size);
        System.out.println("Первоначальный массив ноутбуков");
        Arrays.asList(arr).stream().forEach(s -> System.out.println(s));
        System.out.println("Отсортированный массив ноутбуков");
        QuickSort.sort(arr);
        Arrays.asList(arr).stream().forEach(s -> System.out.println(s));
    }
}
