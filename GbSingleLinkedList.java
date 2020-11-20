package ru.geekbrains.j2_homework8;

public class GbSingleLinkedList implements GbList {
    private Node first;
    private int size = 0;


    @Override
    public void add(String val) {
        if (first == null){
            first = new Node(val);

        } else {
            add(first,val);
        }
        size++;

    }
    private void add(Node current, String val){
        if (current.next == null){
            current.next = new Node(val);
            return;
        }
        add(current.next, val);
    }
    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)){
            first = first.next;
            size--;
            return true;
        }
        Node prev = first;
        Node current = first.next;
        while (current != null){
            if (current.val.equals(val)){
                prev = new Node(prev.val, current.next);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        /*int i = 0;
        GbIterator iterator = iterator();
        while (iterator.hasNext()){
            i++;
        }
        return i;*/
        return size;
    }

    @Override
    public String get(int n) {
        if (size == 0 || n > size || n <= 0){
            return null;
        }
        Node current = first;
        int index = 1;
        while (index < n){
            current = current.next;
            index++;
        }
        return current.val;
    }

    @Override
    public GbIterator iterator() {
        return new StraightForwardIterator(first);
    }

    @Override
    public String toString() {
        return "GbSingleLinkedList{" +
                "first=" + first +
                '}';
    }

    private static class Node{
    private String val;
    private Node next;
        public Node (String val){
            this(val,null);
        }
        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        public String getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
    public static class StraightForwardIterator implements GbIterator{
        private Node current;

        public StraightForwardIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }
    }
}

