package es.raulprietob.pspro;


class Parking {
    private int plazasDisponibles;
    private boolean hayPlazas;
    private int[] plazas;

    Parking(int nPlazas) {
        this.plazasDisponibles = nPlazas;
        hayPlazas = true;
        plazas = new int[nPlazas];
    }


    synchronized void barrera(int id) {
        try {
            while (!hayPlazas) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        plazasDisponibles--;

        if (plazasDisponibles == 0)
            hayPlazas = false;

        aparcar(id);
    }

    private synchronized void aparcar(int id) {
        boolean aparcado = false;

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == 0 && !aparcado) {
                System.out.println(String.format("ENTRADA: Coche %1$s aparca en la plaza %2$s", id, i));
                plazas[i] = id;
                aparcado = true;
            }
        }

        System.out.println("Plazas libres: " + plazasDisponibles);

        System.out.println(getParking());

    }

    synchronized void desaparcar(int id) {

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == id) {
                System.out.println(String.format("SALIDA: Coche %1$s saliendo.", id));
                plazas[i] = 0;
            }
        }

        plazasDisponibles++;
        hayPlazas = true;

        System.out.println("Plazas libres: " + plazasDisponibles);

        System.out.println(getParking());

        notify();
    }

    private StringBuilder getParking() {
        StringBuilder str = new StringBuilder();
        str.append("Parking:");
        for (int plaza : plazas) {
            str.append(" [")
                    .append(plaza)
                    .append("]");
        }
        return str;
    }

}
