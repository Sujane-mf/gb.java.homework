package ru.geekbrains.j2_homework3;
/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать сколько раз встречается каждое слово.
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String > words = new ArrayList<>();
        words.add("apple");
        words.add("orange");
        words.add("banana");
        words.add("apple");
        words.add("banana");
        words.add("orange");
        words.add("orange");
        words.add("apple");
        words.add("banana");
        words.add("apple");
        System.out.println("Исходный массив: " + words);
        Set<String> uniquewords = new HashSet<String>(words);
        System.out.println("Массив из уникальных слов: " + uniquewords);
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String word : words) {
            counts.put(word, counts.containsKey(word)
                    ? counts.get(word) + 1 : 1);
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()){
        System.out.println(entry.getKey() + " = " + entry.getValue());}

        HashMap <String,String> card = new HashMap<String, String>();
        PhoneBook pb1 = new PhoneBook(card);
        try {
            pb1.addCard("9859855948","Иванов");
            pb1.addCard("9859855949","Иванов");
            pb1.addCard("9859855950","Петров");
        } catch (WrongKeyException wk){
            System.out.println(wk.getMessage());
        }

        finally {
            System.out.println(card);
        }
            pb1.getNumber ("Иванов");
               }
        }


