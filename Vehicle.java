package ru.geekbrains.j3_homework5;

public class Vehicle implements Runnable{
    private FuelStation fuelStation; //
    private float volume; //объем бака транспортного средства
    private float currentVolume; //текущее количество топлива в баке
    private float fuelConsumption; //расход топлива
    private String vehicleID; //идентификатор транспортного средства

    public Vehicle(FuelStation fuelStation,float volume, float fuelConsumption, String vehicleID) {
        this.fuelStation = fuelStation;
        this.volume = volume;
        this.fuelConsumption = fuelConsumption;
        this.vehicleID = vehicleID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public float getVolume() {
        return volume;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public float getCurrentVolume() {
        return currentVolume;
    }

    // метод для заправки
    public void getReFill(){
        fuelStation.refill(this);
    }

    // метод движения
    public void move() {
        System.out.println(String.format("[%s] движется", getVehicleID()));
        currentVolume = getVolume();
        //считаем раз в три секунды количество израсходованного топлива, пока топлива хватает на 3 секунды поездки
        //если не хватает заезжаем на заправку
        Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (this) {
                            while (currentVolume > getFuelConsumption() * 3) {
                                Thread.sleep(3000);
                                currentVolume = currentVolume - getFuelConsumption() * 3;
                                System.out.println(String.format("У [%s] текущее состояние бака: [%s]", getVehicleID(), currentVolume));
                            }
                            getReFill();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            t1.start();
        }

    @Override
    public void run() {
        move();
    }
}
