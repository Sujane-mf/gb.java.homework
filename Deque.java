package ru.geekbrains.alg_hw4;

public interface Deque <E>{
    boolean insertLeft(E value);
    boolean insertRight(E value);
    E removeLeft();
    E removeValue(E value);
    E peekFront();
    int size();
    boolean isEmpty();
    boolean isFull();
    void display();
}
