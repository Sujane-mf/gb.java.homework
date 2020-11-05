package ru.geekbrains.j2_homework5;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static float[] arr = new float[size];

    public static void main(String[] args) {
    countingAndTiming();
    splittingAndTiming();
    }
    public static void countingAndTiming(){
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("Время заполнения 1ый метод: " + a);
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a + " - время работы 1 метод");
    }

    public static class ThreadForCounting1 implements Runnable{
        float[] arr1 = Arrays.copyOfRange(arr, 0, arr.length/2);
        @Override
        public void run() {
            for (int i=0; i < size/2; i++){
            arr1 [i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            long b = System.currentTimeMillis();
            System.out.println("Время разбивки массива на 2  и просчета, 1 поток " + b);
        }
    }
    public static class ThreadForCounting2 implements Runnable{
        float[] arr2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        @Override
        public void run() {
            for (int i=0; i < size/2; i++){
                arr2 [i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            long b = System.currentTimeMillis();
            System.out.println("Время разбивки массива на 2 и просчета, 2 поток " + b);
        }
    }
    public static void splittingAndTiming(){
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("Время заполнения 2ый метод: " + a);
        float[] arr1 = Arrays.copyOfRange(arr, 0, arr.length/2);
        float[] arr2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
//        long b = System.currentTimeMillis() - a;
//        System.out.println("Время разбивки массива на 2" + b);
        new Thread ( new ThreadForCounting1()).start();
        new Thread ( new ThreadForCounting2()).start();
        System.arraycopy(arr1, 0, arr, 0, arr.length/2);
        System.arraycopy(arr2, 0, arr, arr.length/2, arr.length/2);
        System.out.println(System.currentTimeMillis() + " - время работы 2 метод");
    }
}


