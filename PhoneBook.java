package ru.geekbrains.j2_homework3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneBook {
    private HashMap<String, Set<String>> card;

    public PhoneBook(HashMap<String, Set<String>> card) {
        this.card = card;
    }

    public void addCard(String surname, String number) {
        if (!card.containsKey(surname)) {
            Set<String> numbers = new HashSet<>();
            numbers.add(number);
            card.put(surname, numbers);
        } else {
            card.get(surname).add(number);
        }
    }

    public Set<String> getNumber(String surname) {
        if (card.get(surname) == null){
            return new HashSet<>();
        }

        return card.get(surname);

            }
        }


