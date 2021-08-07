package ru.geekbrains.alg_hw4;

import java.util.Iterator;

public class TwoSidedLinkedListImpl<E> implements TwoSidedLinkedList, Iterable<E>{

    protected Node<E> firstElement;
    protected Node<E> lastElement;
    protected int size;


    @Override
    public void insertFirst(Object value) {
        firstElement = new Node(value, firstElement);
        size++;
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public void insertLast(Object value) {
        Node<E> newNode = new Node(value, null);

        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }

        lastElement = newNode;
        size++;
    }

    @Override
    public Object removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;

        size--;
        return removedNode.item;
    }

    @Override
    public Object getFirst() {
        return getValue(firstElement);
    }


    @Override
    public Object getLast() {
        return getValue(lastElement);
    }

    protected E getValue(Node<E> value) {

        return value != null ? value.item : null;
    }
    @Override
    public boolean remove(Object value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if(current == firstElement) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(Object value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            Node<E> current = firstElement;
            @Override
            public boolean hasNext() {
                return lastElement.next != null;
            }

            @Override
            public E next() {
                return (E) current.next;

            }
        };
        return it;
    }
}
