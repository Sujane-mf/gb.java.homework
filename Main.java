package ru.geekbrains.j2_homework1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Action> participants = new ArrayList<Action>();
        participants.add(new Human(100, 1));
        participants.add(new Cat(200, 5));
        participants.add(new Robot(1000, 10));
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Treadmill(150));
        obstacles.add(new Wall(2));

        for (Action participant : participants) {

            for (Obstacle obstacle : obstacles) {
                obstacle.overcomeTheObstacle();
                if (obstacle instanceof Treadmill) {participant.run(obstacle);}
                if (obstacle instanceof Wall) {participant.jump(obstacle);}
                }
            }
        }
    }



