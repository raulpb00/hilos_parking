package es.raulprietob.pspro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int nPlazas = Integer.parseInt(args[0]);
        int nCoches = Integer.parseInt(args[1]);

        // Leo el buffer de entrada proveniente del padre (o el teclado)
        /*try (Scanner sc = new Scanner(System.in)) {
            nPlazas = sc.nextInt();
            nCoches = sc.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //Instancio la clase monitor con el dato necesario
        Parking parking = new Parking(nPlazas);

        ArrayList<Coche> listacoches = new ArrayList<>();

        for (int i = 0; i < nCoches; i++) {
            listacoches.add(new Coche(i,parking));
            listacoches.get(i).start();
        }


       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tecla;
        try {
            while (!(tecla = br.readLine()).equals("p")){
                Thread.sleep(1);
            }
            for (Coche coche:listacoches) {
                coche.matarHilo();
            }

        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }*/


    }
}
