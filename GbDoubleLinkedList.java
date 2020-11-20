package ru.geekbrains.j2_homework8;

public class GbDoubleLinkedList implements GbList{
    private Node head;
    private int size = 0;


    @Override
    public void add(String val) {
    if (head == null){
        head = new Node(val);
    } else {
        add(head,val);
    }
    size++;
    }

    private void add(Node current, String val){
        if (current.next == null){
                current.next = new Node(current,val);
                return;
        }
            add(current.next, val);
        }


    @Override
    public boolean remove(String val) {
        if (head.val.equals(val)){
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        Node prev = head;
        Node current = head.next;
        while (current.next != null){
            if (current.val.equals(val)){
                current.next.prev = current.prev;
                current.prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        if (current.next == null && current.val.equals(val)){
            current.prev.next = null;
            size--;
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int n) {
        if (size == 0 || n > size || n <= 0){
            return null;
        }
        Node current = head;
        int index = 1;
        while (index < n){
            current = current.next;
            index++;
        }
        return current.val;
    }

    @Override
    public GbIterator iterator() {
        return null;
    }

    @Override
    public String toString() {
        return "GbDoubleLinkedList{" +
                "head=" + head +
                '}';
    }

    private static class Node{
        private Node prev;
        private String val;
        private Node next;

        public Node(String val) {
            this(null,val,null);
        }

        public Node(Node prev, String val) {
            this(prev,val,null);
        }

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(Node prev, String val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            if (prev == null){
                return "Node{" +
                        "prev=" + null +
                        ", val='" + val + '\'' +
                        ", next=" + next +
                        '}';
            }
            if (next == null){
                return "Node{" +
                        "prev=" + prev.val +
                        ", val='" + val + '\'' +
                        ", next=" + null +
                        '}';
            }
                return "Node{" +
                    "prev=" + prev.val +
                    ", val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

}
