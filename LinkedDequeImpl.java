package ru.geekbrains.alg_hw4;

public class LinkedDequeImpl<E> implements Deque {

    private final TwoSidedLinkedList<E> data;
    public LinkedDequeImpl() {
        this.data = new TwoSidedLinkedListImpl<>();
    }

    @Override
    public boolean insertLeft(Object value) {
        data.insertFirst((E) value);
        return true;
    }

    @Override
    public boolean insertRight(Object value) {
        data.insertLast((E) value);
        return true;
    }

    @Override
    public Object removeLeft() {
        return data.removeFirst();
    }

    @Override
    public Object removeValue(Object value) {
        return data.remove((E) value);
    }

    @Override
    public Object peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }
    @Override
    public String toString() {
        return "LinkedQueueImpl{" + "data=" + data + '}';
    }
}
