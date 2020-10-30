package ru.geekbrains.j2_homework1;

public class Cat implements Action {
    int maxlength, maxheight; //ограничения на длину забега и высоту прыжка

    public Cat(int maxlength, int maxheight) {
        this.maxlength = maxlength;
        this.maxheight = maxheight;
    }

    public boolean run(int size) {
        if (maxlength >= size) {
            System.out.println("Кот пробежал дорожку длиной " + size);
            return true;
        } else {
            System.out.println("Кот не смог пробежать дорожку, его ограничения " + maxlength);
            return false;
        }
    }

    public boolean jump(int size) {
        if (maxheight >= size) {
            System.out.println("Кот перепрыгнул стену высотой " + size);
            return true;
        } else {
            System.out.println("Кот не смог перепрыгнуть стену, его ограничения " + maxheight);
            return false;
        }
    }
}

