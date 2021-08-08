package ru.geekbrains.j2_homework1;

public class Cat implements Action{
    int maxlength, maxheight; //ограничения на длину забега и высоту прыжка
    public Cat (int maxlength, int maxheight){
        this.maxlength = maxlength;
        this.maxheight = maxheight;
    }
    public boolean run (Obstacle obs){
        if (obs instanceof Treadmill && maxlength >= ((Treadmill) obs).size){
            System.out.println("Кот пробежал дорожку ");
            return true;
        }else {System.out.println("Кот не смог пробежать дорожку, его ограничения " + maxlength);
            return false;
        }
    }

    public void jump(Obstacle obs) {
        if (obs instanceof Wall && maxheight >= ((Wall) obs).size) {
            System.out.println("Кот перепрыгнул стену ");

        }else {System.out.println("Кот не смог перепрыгнуть стену, его ограничения " + maxheight);

        }
    }
}
