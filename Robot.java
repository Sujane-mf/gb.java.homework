package ru.geekbrains.j2_homework1;

public class Robot implements Action{
    int maxlength, maxheight; //ограничения на длину забега и высоту прыжка
    public Robot (int maxlength, int maxheight){
        this.maxlength = maxlength;
        this.maxheight = maxheight;
    }
    public boolean run (int size){
        if (maxlength >= size) {
        System.out.println("Робот пробежал дорожку длиной " );
            return true;
        } else {System.out.println("Робот не смог пробежать дорожку, его ограничения " + maxlength);
        return false;
       }
    }

    public boolean jump(int size) {
        if (maxheight >= size) {
            System.out.println("Робот перепрыгнул стену высотой " + size);
            return true;
        }
        else {System.out.println("Робот не смог перепрыгунть стену, его ограничения " + maxheight);
            return false;
               }
    }
}
