package ru.geekbrains.homework4;

import java.util.Random;
import java.util.Scanner;

public class Main {
public static char[][] map;
public static int SIZE = 3;
public static int DOTS_TO_WIN = 3;
public static final char DOT_EMPTY = '.';
public static final char DOT_X = 'X';
public static final char DOT_0 = 'O';
public static Scanner sc = new Scanner(System.in);
public static Random rand = new Random();
    public static void main(String[] args) {
	initMap();
	printMap();
	while (true) {
	    humanTurn();
	    printMap ();
            if (checkWin2(DOT_X)) {
                System.out.println ("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println ("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin2 (DOT_0)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static void initMap()
    {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap()
    {
        for (int i = 0; i <= SIZE; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++)
        {
            System.out.print (( i + 1 ) + " " );
            for ( int j = 0; j < SIZE; j ++)
            {
                System.out.print(map[ i ][ j ] + " " );
            }
            System.out.println ();
        }
    }
    public static void humanTurn()
    {
        int x,y;
        do {
            System.out.println ("Введите координаты в формате X Y");
            x = sc.nextInt()-1;
            y = sc.nextInt()-1;
        } while (!isCellValid(x,y));
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y)
    {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static boolean isMapFull(){
        for (int i = 0; i < SIZE; i ++) {
            for (int j = 0; j < SIZE; j ++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true ;
    }
    public static void aiTurn()
    {
        int x , y ;
        do {
        x = rand.nextInt(SIZE);
        y = rand.nextInt(SIZE);
        } while (!isCellValid (x,y));
        System.out.println("Компьютер походил в точку " + (x+1) + " " + (y+1));
        map[y][x] = DOT_0;
    }
//    public static boolean checkWin(char symb)
//    {
//        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
//        return false ;
//    }
    //делаем новый метод для поиска победителя
    public static boolean checkWin2 (char symb)
    {
    if (checkDiagonal(symb)) return true; //проверяем диагонали
    if (checkLines(symb)) return true; //проверяем столбцы и строки
    return false;
    }
    // Делаем метод для проверки диагоналей.
    // Вводим 2 переменные со значением true для главной и побочной диагонали
    // после чего последовательно применяем логическое И
    // значение переменной останется true только в случае, если с обеих сторон 1, т.е. в нужной ячейке переданный в метод символ
    public static boolean checkDiagonal(char symb) {
        boolean main, side;
        main = true;
        side = true;
        for (int i = 0; i < SIZE; i++) {
            main &= (map[i][i] == symb);
            side &= (map[SIZE-i-1][i] == symb);
        }

        if (main || side) return true; // возвращаем тру, если последовательно заполнена одинаковым символом главная или побочная диагональ
        return false;
    }
    // Делаем метод для проверки столбцов и строк по аналогии
    public static boolean checkLines(char symb) {
        boolean cols, rows;
        for (int col = 0; col < SIZE; col++) {
            cols = true;
            rows = true;
            for (int row=0; row<SIZE; row++) {
                cols &= (map[col][row] == symb);
                rows &= (map[row][col] == symb);
            }
            if (cols || rows) return true;
        }
        return false;
    }
}
