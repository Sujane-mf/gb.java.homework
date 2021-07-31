package ru.geekbrains.alg_hw3;
//1. Дан массив из n элементов, начиная с 1.
// Каждый следующий элемент равен (предыдущий + 1). Но в массиве гарантированно 1 число пропущено.
// Необходимо вывести на экран пропущенное число.
//2. Создать класс для реализации дека.
//3. Доработать очереди, чтобы после удаления освобождались ячейки для записи (без сдвига)
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testDequeue();
        int size = 10;
        Array a1 = new Array(size);
        Integer [] arr1 = a1.fillTheArray(size);
        System.out.println("Полный массив: " + Arrays.toString(arr1));
        Integer [] arr2 = a1.getFinalArray(arr1);
        System.out.println("Массив с пропущенным элементом: " + Arrays.toString(arr2));
        System.out.println("Пропущенный элемент: " + Search.search(arr2));

    }
    private static void testDequeue() {
        Deque<Integer> dec = new Dec<>(6);

        System.out.println("add element: " + dec.insertRight(34));
        System.out.println("add element: " + dec.insertRight(12));
        System.out.println("add element: " + dec.insertRight(20));
        System.out.println("add element: " + dec.insertRight(16));
        System.out.println("add element: " + dec.insertRight(14));
        dec.display();
        System.out.println("add element: " + dec.insertLeft(25));//не удалось не терять хвост
        dec.display();
        System.out.println("remove: " + dec.removeLeft());
        dec.display();
        System.out.println("add element: " + dec.insertRight(27));//после предыдущего удаления элемент записывается
        dec.display();
        System.out.println("remove: " + dec.removeRight());
        dec.display();

    }

}
