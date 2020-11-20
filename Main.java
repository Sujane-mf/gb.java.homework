package ru.geekbrains.j2_homework8;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	GbList list = new GbSingleLinkedList();
	list.add("VOLVO");
	list.add("Ford");
	list.add("Smart");
		System.out.println(list);
	 GbIterator iterator = list.iterator();
	    while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
	 System.out.println(list.size());
	 System.out.println(list.get(2));
	GbList dblList = new GbDoubleLinkedList();
	dblList.add("apple");
	dblList.add("orange");
	dblList.add("pineapple");

		System.out.println(dblList);
		System.out.println(dblList.size());
		System.out.println(dblList.get(2));
		dblList.remove("pineapple");
		System.out.println(dblList);
		System.out.println(dblList.size());
    }

}
