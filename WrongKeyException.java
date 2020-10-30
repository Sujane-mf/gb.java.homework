package ru.geekbrains.j2_homework3;

public class WrongKeyException extends Exception {
    public WrongKeyException() {
    }

    public WrongKeyException(String message) {
        super(message);
    }
}
