package com.ReinosCenfotecosService.Core.Timer;

import java.io.Serializable;

public class ObservadorC implements Observador {

    private String gNombre;
    private boolean completed;

    public ObservadorC(String pN) {
        gNombre = pN;
    }

    public void update(Serializable value) {
        mostrarValor(value, "");
    }

    private boolean mostrarValor(Serializable value, String pNomProducto) {
        boolean trigger = false;
        if (pNomProducto.equals("Tiempo")) {
            System.out.println("El " + pNomProducto + " ahora es: " + value + " segundos, en " + gNombre + ".");

        } else {
            System.out.println("Ahora hay un total de: " + value + " " + gNombre + ".");
            //Ocupamos que llegue a 15 abejas en el observador
            if ((int) value == 2) {
                System.out.println("Listo");
                trigger = true;
            }
        }
        return trigger;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void update(Serializable value, String nombre) {
        mostrarValor(value, nombre);

    }

}
