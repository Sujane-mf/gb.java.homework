package ru.geekbrains.alg_hw2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSort {

    public static List<Notebook> quickSort(List<Notebook> nb) {

        if (nb.isEmpty()) {
            return nb; //завершаем выполнение если лист пустой
        }
        // берем базовый элемент
        Notebook base = nb.get(0);
        // формируем списки для сортировки
        List<Notebook> left = new LinkedList<>();
        List<Notebook> middle = new LinkedList<>();
        List<Notebook> right = new LinkedList<>();

        // задаем условия сортировки
        for (Notebook n : nb) {
            if (n.equals(base)) {
                middle.add(n);
            } else if (n.cost > base.cost) {
                right.add(n);
            } else if (n.cost == base.cost) {
                if (n.RAM > base.RAM)
                {
                    right.add(n);
                }  else if (n.RAM == base.RAM){
                    if (n.scaleForSortBrand(n.brand) > n.scaleForSortBrand(base.brand)){
                        right.add(n);
                    }else {left.add(n);}
                }else {left.add(n);}

            } else {
                left.add(n);
            }
        }

        left = quickSort(left);
        right = quickSort(right);

        left.addAll(middle);
        left.addAll(right);

        return left;
    }
    public static void sort(Notebook[] arr) {
        List<Notebook> list = Arrays.asList(arr);

        quickSort(list).toArray(arr);
    }

}
