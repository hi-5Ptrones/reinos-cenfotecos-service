package com.ReinosCenfotecosService.Core.Observador;

import com.ReinosCenfotecosService.Entities.Partida;
import java.io.Serializable;

public class ObservadorC implements Observador {

    private String gNombre;
    private boolean completed;

    public ObservadorC(String pN) {
        gNombre = pN;
    }

    public void update(Partida value) {
        mostrarValor(value, "");
    }

    private Partida mostrarValor(Partida pPartida, String pNomProducto) {
        if (pNomProducto.equals("Vidas")) {
            System.out.println("Ahora hay un total de : " + pPartida.getJugador1().getVidaCastillo() + " " + pNomProducto + " para el jugador 1 /n"
                    + pPartida.getJugador2().getVidaCastillo() + " " + pNomProducto + " para el jugador 2");

            if ((pPartida.getJugador1().getVidaCastillo() == 0)) {
                pPartida.setGanador(2);
                pPartida.setEstado(0);
            } else if ((pPartida.getJugador2().getVidaCastillo() == 0)) {
                pPartida.setGanador(1);
                pPartida.setEstado(0);
            }
        }

        return pPartida;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public Partida update(Partida value, String nombre) {
        //este es el que se usa realmente
        return mostrarValor(value, nombre);

    }

}
