package ru.geekbrains.j2_homework1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Action[] participants = {new Human(100,1), new Cat(200,5), new Robot(1000,10)};
        Obstacle[] obstacles = {new Treadmill(150), new Wall(2)};

        for (Action participant : participants) {

            for (Obstacle obstacle : obstacles) {
                if (obstacle.overcomeTheObstacle(participant)== false){
                    System.out.println("Участник завалился и дальше не преодолевает препятствия");
                    break;}
                                }
            }
        }
    }



