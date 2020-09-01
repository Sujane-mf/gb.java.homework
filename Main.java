package ru.geekbrains.homework2;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

	    int [] arr = new int[3];
	    int [] arr2 = new int[8];
	    int [] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
	    int [][] arr4 = new int[3][3];
	    int [] arr5 = new int[5];
	    int [] arr6 = {1, 5, 2,4};
	    fillTheArray(arr);
	    System.out.println("Вы сформировали массив");
        System.out.println(Arrays.toString(arr));
        change0to1(arr);
        System.out.println("Массив после замены");
        System.out.println(Arrays.toString(arr));
        fillTheNewArray(arr2);
        System.out.println("Массив для второго задания");
        System.out.println(Arrays.toString(arr2));
        System.out.println("Массив для 3его задания");
        System.out.println(Arrays.toString(arr3));
        multipleTheArray(arr3);
        System.out.println("Массив для 3его задания после умножения");
        System.out.println(Arrays.toString(arr3));
        System.out.println("Заполняем массив для 4го задания");
        fillTheArray4(arr4);
        System.out.println("Ваш массив");
        printArr4(arr4);
        System.out.println("Меняем на 1 основную диагональ");
        changeTo1Main(arr4);
        printArr4(arr4);
        System.out.println("Меняем на 1 побочную диагональ");
        changeTo1Side(arr4);
        printArr4(arr4);
        System.out.println("Заполняем массив для 5ого задания");
        fillTheArray5(arr5);
        System.out.println(Arrays.toString(arr5));
        System.out.println("Находим минимальное и максимальное значение");
        findMinAndMax(arr5);
        System.out.println("Массив из 6ого задания");
        System.out.println(Arrays.toString(arr6));
        checkBalance(arr6);    }
	// заполняем массив для первого задания
    public static void fillTheArray(int [] arr){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i< arr.length; i++){
            System.out.println  ("Введите 0 или 1: ");
            arr[i] = scanner.nextInt();
        }
                }
    // меняем 0 на 1
    public static void change0to1(int [] arr){
        for(int i = 0; i< arr.length; i++){
            if (arr[i]==0){
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            }
        }
    // заполняем массив для второго задания
    public static void fillTheNewArray(int [] arr2){
                for(int i = 0; i< arr2.length; i++){
                        arr2[i] = i*3;
        }
    }
    // выполняем 3е задание
    public static void multipleTheArray(int [] arr3){
        for(int i = 0; i< arr3.length;i++){
            if (arr3[i]<6){
                arr3[i] *=2;}
        }
    }
    // выполняем 4е задание
    // заполняем массив
    public static void fillTheArray4 (int [][] arr4){
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<arr4.length; i++){
                        for (int j=0; j<arr4[i].length;j++){
                System.out.println("Введите любое число");
                arr4[i][j] = scanner.nextInt();
                                                            }
                                }
    }
    // меняем введенное значение на 1 в основной диагонали
    public static void changeTo1Main (int [][] arr4){
        System.out.println("Мы поменяем Ваше значение на 1, если мы в основной диагонали");
        for (int i=0; i<arr4.length; i++){
            for (int j=0; j<arr4[i].length;j++){
                if (i == j){
                    arr4[i][j] = 1;
                }
            }
        }

    }
    // меняем введенное значение на 1 в побочной диагонали
    public static void changeTo1Side (int [][] arr4) {
        System.out.println("Мы поменяем Ваше значение на 1, если мы в побочной диагонали");
                for (int i = 0, j = 2; i < arr4.length; i++, j--){
            arr4[i][j] = 1;
        }
                /*у меня не получается сделать j равным длине строчки массива через arr4[i].length
                цикл ломается, почему не поняла.
                 */
        }

    // печатаем массив 4ого задания
    public static void printArr4(int[][] arr4) {
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j]);
            }
            System.out.println();
        }
    }

// находим минимальное и максимальное значение в массиве
public static void fillTheArray5(int [] arr5){
    Scanner scanner = new Scanner(System.in);
    for(int i = 0; i< arr5.length; i++){
        System.out.println  ("Введите любое целое число: ");
        arr5[i] = scanner.nextInt();
    }
}
public static void findMinAndMax(int [] arr5){
        int min,max;
        min = arr5[0];
        max = arr5[0];
        for (int i = 1; i< arr5.length; i++){
                        if (arr5[i]<min){
                            min = arr5[i];
                        }
                        else if (arr5[i]>max){
                            max = arr5[i];
                        }
                           }
        System.out.println("Минимальное значение: "+min);
    System.out.println("Максимальное значение: "+max);
        }
//сверяем сумму
public static void checkBalance (int [] arr6){
    int sumleft = 0;

        for(int i=0; i < 3; i++){
            sumleft += arr6[i];
            int sumright = 0;
            for(int j = i+1; j<4;j++){
                sumright += arr6[j];
                                }
            System.out.println("Левая сумма "+sumleft);
            System.out.println("Правая сумма "+sumright);
            if (sumleft == sumright){
                System.out.println("true");
            } else {System.out.println("Суммы не равны");
            }
        }
}
}

