package ru.geekbrains.alg_hw2;

import java.util.Random;

public class Notebook {
    final String[] brands = new String[]{"Lenuvo", "Asos", "MacNote", "Eser", "Xamion"};
    final int[] memory = new int[]{4,8,12,16};
    final int[] price = new int[]{500,600,700,800,900,1000};
    int cost;
    int RAM;
    String brand;

    public Notebook() {
           this.cost = getPrice(price);
           this.RAM = getRAM(memory);
           this.brand = getBrand(brands);

        //this.cost = Math.round((Math.random() * 4 + 80000)*100)/100.00;
                        }
    public static String  getBrand (String []b)
    {
        Random generator = new Random();
        int ranInd = generator.nextInt(b.length);
        return b[ranInd];
    }
    public static int scaleForSortBrand(String b){
           int scale;
        switch (b){
            case ("Lenuvo"):
              scale = 4;
                break;
            case ("Asos"):
              scale = 3;
                break;
            case ("MacNote"):
              scale = 2;
                break;
            case ("Eser"):
              scale = 1;
                break;
            case ("Xamion"):
              scale = 0;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + b);
        }
        return scale;
    }
    public static int getRAM(int [] r){
        Random generator = new Random();
        int ranInd = generator.nextInt(r.length);
        return r[ranInd];
    }
    public static int getPrice(int [] p){
        Random generator = new Random();
        int ranInd = generator.nextInt(p.length);
        return p[ranInd];
    }

    public static Notebook[] getArray(int length){
        Notebook[] arr = new Notebook[length];
        for (int i = 0; i<length; i++){
            arr[i] = new Notebook();
                    }
        return arr;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "Цена: " + cost +
                ", Оперативная память: " + RAM +
                ", Бренд: " + brand +
                '}';
    }

    }
