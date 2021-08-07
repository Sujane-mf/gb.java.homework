package ru.geekbrains.alg_hw4;

public interface TwoSidedLinkedList<E> {

    void insertFirst(E value);
    void insertLast(E value);
    E removeFirst();
    boolean remove(E value);

    E getFirst();
    E getLast();


    boolean contains(E value);
    boolean isEmpty();

    int size();
    void display();

    class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;

        public Node(E item, Node<E> next) {
            this(item, next, null);
        }

        public Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }


    }

}
