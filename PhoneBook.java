package ru.geekbrains.j2_homework3;

import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, String> card;

    public PhoneBook(HashMap<String, String> card) {
        this.card = card;
    }

    public void addCard(String number, String surname) throws WrongKeyException {
        if (!card.containsKey(number)) {
            card.put(number, surname);
        } else {
            throw new WrongKeyException("Такой номер телефона уже есть " + number);
        }
    }

    public void getNumber(String surname) {
        for (HashMap.Entry<String, String> entry : card.entrySet()) {
            if (entry.getValue().equals(surname)) {
                System.out.println("Телефон сотрудника " + surname + ": " + entry.getKey());
            }
        }
    }
}


