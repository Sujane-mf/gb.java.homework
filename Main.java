package ru.geekbrains.alg_hw5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

// 1. Написать программу по возведению числа в степень с помощью рекурсии.
// 2. Написать программу «Задача о рюкзаке» с помощью рекурсии
public class Main {

    public static void main(String[] args) {

    ArrayList<Item> items = new ArrayList<Item>();

    items.add(new Item("book",600,1));
    items.add(new Item("binoculars", 5000, 3));
    items.add(new Item("kit", 1500,4));
    items.add(new Item("laptop", 40000,5));
    items.add(new Item("pot",500,3));
    //проверяю исходный список
    items.stream().forEach(s -> System.out.println(s));
    //проверяю, что список отсортирован по цене
    QuickSort.sort(items).stream().forEach(s -> System.out.println(s));
    int capacity = items.size();
    //печатаю, полный состав наполненного рюкзака
    Backpack bp1 = new Backpack(15, QuickSort.sort(items));
    //в рюкзак передаю уже отсортированный список, чтобы добавлять сразу дорогие предметы
    bp1.fillBackpack(15,QuickSort.sort(items),capacity).stream().forEach(s -> System.out.println(s));



//    Exponentiation exp = new Exponentiation();
//        System.out.println("Итог возведения в степень: " + exp.exponentiate(5,3));
//        System.out.println("Итог возведения в степень: " + exp.exponentiate(2,12));
    }
}
