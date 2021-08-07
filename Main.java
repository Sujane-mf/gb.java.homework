package ru.geekbrains.alg_hw4;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedDequeImpl<Integer> linkedDeque = new LinkedDequeImpl<Integer>();
        linkedDeque.insertLeft(1);
        linkedDeque.insertLeft(2);
        linkedDeque.insertRight(3);
        linkedDeque.insertRight(4);
        linkedDeque.display();

        linkedDeque.removeLeft();
        linkedDeque.display();

        linkedDeque.removeValue(4);
        linkedDeque.display();


        TwoSidedLinkedListImpl<Integer> linkedList = new TwoSidedLinkedListImpl<Integer>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 7: " + linkedList.contains(7));

        linkedList.removeFirst();
        linkedList.display();

        linkedList.remove(2);
        linkedList.display();

        for (Integer value : linkedList) {
            System.out.println(value);
        }
    }
}
