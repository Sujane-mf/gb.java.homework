package ru.geekbrains.alg_hw3;

public class Search {
public static int search(Integer [] arr){
    int n = arr.length; //количество

    int sum = (n+1)*(n+2)/2; //сумма всех элементов изначально массива
    //System.out.println("Сумма всех элементов изначального массива: " + sum);
    int sumn = 0;
    for (int i=0; i<arr.length; i++){
        sumn += arr[i];
    }
    //System.out.println("Сумма всех элементого нового массива: " + sumn);
    int el = sum - sumn;
    return el;

}
}
