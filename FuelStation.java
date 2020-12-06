package ru.geekbrains.j3_homework5;

import java.util.concurrent.Semaphore;

public class FuelStation {
    private Semaphore semaphore;
    private GasPool gp = new GasPool();


    public FuelStation(Semaphore semaphore, GasPool gp) {
        this.semaphore = semaphore;
        this.gp = gp;
    }

    public void refill (Vehicle vehicle){
        try {
            semaphore.acquire();
            System.out.println(String.format("[%s] заехал на заправку", vehicle.getVehicleID()));
            float amount = vehicle.getVolume() - vehicle.getCurrentVolume();
            System.out.println(String.format("Для [%s] требуется топлива [%s]", vehicle.getVehicleID(), amount));
            System.out.println(String.format("[%s] заправляется", vehicle.getVehicleID()));
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (this) {
                        if (gp.info() >= amount) {
                            gp.request(amount);
                        }
                    }
                }
                });
            t2.start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(String.format("[%s] заправился и освободил заправку", vehicle.getVehicleID()));
        }

    }


}
