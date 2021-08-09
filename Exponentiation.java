package ru.geekbrains.alg_hw5;

public class Exponentiation {
    int number;
    int degree;

    public int exponentiate(int n, int d) {
        if (d == 0) {
            return 1;
        } else if (d == 1) {
            return n;
        } else {
            return n * exponentiate(n, d - 1);
        }
    }
}
