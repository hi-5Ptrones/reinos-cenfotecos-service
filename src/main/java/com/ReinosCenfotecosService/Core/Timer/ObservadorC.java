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

    private void mostrarValor(Serializable value, String pNomProducto) {
        if (pNomProducto.equals("Tiempo")) {
            System.out.println("Le quedan: " + value + " segundos, a su turno.");

        } else {
            System.out.println("Ahora hay un total de: " + value + " " + gNombre + ".");
            //Ocupamos que llegue a 15 abejas en el observador
            if ((int) value == 2) {
                System.out.println("Listo");
            }
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void update(Serializable value, String nombre) {
        //este es el que se usa realmente
        mostrarValor(value, nombre);

    }

}
