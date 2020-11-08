package ru.geekbrains.j2_homework5;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] arr1 = new float[h];
    static float[] arr2 = new float[h];
    public static void main(String[] args) {
    countingAndTiming(arr);
    splittingAndTiming(arr,arr1,arr2,h);
    }
    public static void countingAndTiming(float[]a0){
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("Время заполнения единицами 1ый метод: " + a);
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a + " - время работы 1 метод");
    }


    public static void splittingAndTiming(float[]a, float[]a1, float[]a2, int s)  {
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long start = System.currentTimeMillis();
        System.out.println("Время заполнения единицами 2ый метод: " + start);
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        long b = System.currentTimeMillis() - start;
        System.out.println("Время разбивки массива на 2: " + b);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //synchronized (arr1) {
                    for (int i = 0; i < h; i++) {
                        arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                    long b = System.currentTimeMillis();
                    System.out.println("Время замены, 1 поток " + b);
                //}
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //synchronized (arr2) {
                    for (int i = 0; i < h; i++) {
                        arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                    long b = System.currentTimeMillis();
                    System.out.println("Время замены, 2 поток " + b);
                //}
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
            }
        catch (InterruptedException e){e.printStackTrace();}
//        synchronized (arr1){System.arraycopy(arr1, 0, arr, 0, h);}
//        synchronized (arr2){System.arraycopy(arr2, 0, arr, h, h);}
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long end = System.currentTimeMillis() - start - b;
        System.out.println("Время работы 2 метод: " + end);

           }

    }



