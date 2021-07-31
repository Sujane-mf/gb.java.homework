package ru.geekbrains.alg_hw3;

import java.util.HashMap;

public class Dec<E> implements Deque {

    public static final int HEAD_DEFAULT = 0;
    public static final int TAIL_DEFAULT = -1;
    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;

    public Dec(int maxSize) {
        this.data = (E[]) new Object [maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insertLeft(Object value) {
        if (isFull()) {
            return false;
        }

        System.arraycopy(data, 0, data, 1, data.length-1);
        data[head] = (E) value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(Object value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = TAIL_DEFAULT;
        }

        data[++tail] = (E) value;
        size++;
        return true;
    }

    @Override
    public Object removeLeft() {
        if (isEmpty()) {
            return null;
        }

        E value = data[head++];
        size--;

        return value;
    }

    @Override
    public Object removeRight() {
        if (isEmpty()) {
            return null;
        }
        E value = data[tail--];
        size--;

        return value;
    }

    @Override
    public Object peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--> [");
        for (int i = head; i <= tail; i++) {
            sb.append(data[i]);
            if (i != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
