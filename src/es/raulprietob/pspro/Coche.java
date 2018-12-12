package es.raulprietob.pspro;

import java.util.Random;

public class Coche extends Thread {
    private static final int MAX_APARCAMIENTOS = 5;

    private Parking parking;
    private int id;

    Coche(int id, Parking parking) {
        this.id = id + 1; // Evitamos coche con id = 0
        this.parking = parking;
    }

    @Override
    public void run() {

        try {
            for (int vecesAparcado = 0; vecesAparcado < MAX_APARCAMIENTOS; vecesAparcado++) {
                Thread.sleep((long) (Math.random() * 10000 + 1));
                System.err.println("--Coche " + id + " quiere aparcar");
                parking.barrera(id);
                Thread.sleep((long) (Math.random() * 10000 + 1));
                parking.desaparcar(id);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
