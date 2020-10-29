package ru.geekbrains.j2_homework1;

public class Human implements Action {
    int maxlength, maxheight; //ограничения на длину забега и высоту прыжка

    public Human(int maxlength, int maxheight) {
        this.maxlength = maxlength;
        this.maxheight = maxheight;
    }

    public boolean run(int size) {
        if (maxlength >= size) {
            System.out.println("Человек пробежал дорожку длиной ");
            return true;
        } else {
            System.out.println("Человек не смог пробежать дорожку, его ограничения " + maxlength);
            return false;
        }
    }

    public boolean jump(int size) {
        {
            if (maxheight >= size) {
                System.out.println("Человек перепрыгнул стену высотой " + size);
                return true;
            } else {
                System.out.println("Человек не смог перепрыгнуть стену, его ограничения " + maxheight);
                return false;
            }

        }

    }
}
