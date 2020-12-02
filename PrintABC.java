package ru.geekbrains.j3_homework4;

public class PrintABC implements Runnable {
    static Object lock = new Object();
    static char Letter = 'A';
    private char currentLetter;
    private char nextLetter;

    public PrintABC(char currentLetter, char nextLetter) {
        this.currentLetter = currentLetter;
        this.nextLetter = nextLetter;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                try {
                    while (Letter != currentLetter){
                        lock.wait();
                    }
                    System.out.print(currentLetter);
                    Thread.sleep(1000);
                    Letter = nextLetter;
                    lock.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
