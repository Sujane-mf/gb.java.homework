package ru.geekbrains.alg_hw3;

public interface Deque <E> {
    boolean insertLeft(E value);
    boolean insertRight(E value);
    E removeLeft();
    E removeRight();
    E peekFront();
    int size();
    boolean isEmpty();
    boolean isFull();
    void display();
}
