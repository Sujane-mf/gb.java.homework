package ru.geekbrains.j2_homework2;

import java.util.Scanner;

public class CheckArr {
// метод для проверки длины
    public static void checkArrSize(String[][] arr) throws MyArraySizeException {
        if (arr.length == 2 && arr[0].length == 2) {
            System.out.println("Массив соответствует заданному размеру 4 на 4");
        } else {
            throw new MyArraySizeException("Массив не соответствует заданному размеру");
        }
    }
 // метод для заполнения массива
    public static void fillTheArr(String[][] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println("Введи символ или число");
                arr[i][j] = sc.next();
            }
        }
    }

 // метод для печати массива в консоль
    public static void printArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
 // метод для проверки элементов и суммирования числовых
    public static void convertAndSum(String[][]arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){

                                        try{
                sum += Integer.parseInt(arr[i][j]);
            } catch (RuntimeException nm){
                throw new MyArrayDataException("В ячейке [" +i+ "][" +j+ "] данные неверного формата");
                            }
                                        finally {
                                            System.out.println("Сумма " + sum);
                                        }
            }
        }
      }
}
