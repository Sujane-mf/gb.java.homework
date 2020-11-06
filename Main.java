package ru.geekbrains.j2_homework5;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static float[] arr = new float[size];
    public static void main(String[] args) {
    countingAndTiming(arr);
    splittingAndTiming(arr);
    }
    public static void countingAndTiming(float[]arr){
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
    public static void splittingAndTiming(float[]arr)  {
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("Время заполнения 2ый метод: " + a);
        float[] arr1 = Arrays.copyOfRange(arr, 0, arr.length/2);
        float[] arr2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        long b = System.currentTimeMillis() - a;
        System.out.println("Время разбивки массива на 2 " + b);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < size/2; i++){
                    arr1 [i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                long b = System.currentTimeMillis();
                System.out.println("Время замены, 1 поток " + b);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < size/2; i++){
                    arr2 [i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                long b = System.currentTimeMillis();
                System.out.println("Время замены, 2 поток " + b);
            }
        });
        try{
            Thread.sleep(10000);
                    }catch (InterruptedException e) {e.printStackTrace();}
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
            System.arraycopy(arr1, 0, arr, 0, arr.length/2);
            System.arraycopy(arr2, 0, arr, arr.length/2, arr.length/2);
            System.out.println(System.currentTimeMillis() + " - время работы 2 метод");
        } catch (InterruptedException e){e.printStackTrace();}
           }

    }


