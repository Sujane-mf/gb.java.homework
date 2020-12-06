package ru.geekbrains.j3_homework5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
* Создать классы Car, Truck, Bus. Каждый обладает объемом топлива и расходом (Car - 20\2.5, Truck - 60\15, Bus - 40\7.5)
и уникальных значением для определения среди разных транспортных средств. +
* Для каждого транспортного средства оставшиеся в баке количество топлива вычисляется раз в 3 сек. +
* Создать до 10 экземпляров разных транспортных средств и запустить их в работу. +
* Создать класс GasPool. Обладает максимальными запасом топлива 200f и методами:
request(float amount) - для получения необходимого кол-ва топлива и
info() - для выведения информации о фактическом состоянии.
* Создать класс FuelStaion. Обладает свойством GasPool.
FuelStaion одновременно может заправлять только 3 автомобиля, остальные должны пока не освободится место (порядок не имеет значения).
При заправке автомобиля запрашивается необходимое количество топливо, которое поступает из GasPool.
Необходимое топливо для автомобиля вычисляется на основании формулы R = C - F, где С это объем бака,
а F - фактическое состояние бака
Заправка занимает 5 сек, зачем транспортное средство освобождает место + */
public class Main {

    public static void main(String[] args) {
        GasPool gp = new GasPool();
        FuelStation fuelStation = new FuelStation(new Semaphore(3),gp);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new Car(fuelStation,20f, 2.5f, "car_1"));
        executorService.submit(new Car(fuelStation, 20f, 2.5f, "car_2"));
        executorService.submit(new Car(fuelStation, 20f, 2.5f, "car_3"));
        executorService.submit(new Truck(fuelStation, 60f, 15f, "truck_1"));
//        executorService.submit(new Truck(fuelStation, 60f, 15f, "truck_2"));
//        executorService.submit(new Truck(fuelStation, 60f, 15f, "truck_3"));
//        executorService.submit(new Truck(fuelStation, 60f, 15f, "truck_4"));
//        executorService.submit(new Bus(fuelStation, 40f, 7.5f, "bus_1"));
//        executorService.submit(new Bus(fuelStation,40f, 7.5f, "bus_2"));
//        executorService.submit(new Bus(fuelStation,40f, 7.5f, "bus_3"));

        executorService.shutdown();

    }
}
