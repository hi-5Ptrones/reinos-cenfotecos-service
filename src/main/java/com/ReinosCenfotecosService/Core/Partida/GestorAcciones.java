/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.Partida;

import com.ReinosCenfotecosService.Core.Personajes.GestorPersonajes;
import com.ReinosCenfotecosService.Entities.Casilla;
import com.ReinosCenfotecosService.Entities.Partida;
import com.ReinosCenfotecosService.Entities.DataInvocar;
import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author jorge
 */
public class GestorAcciones {

    GestorPersonajes gpersonajes = new GestorPersonajes();
    GestorPartidas gPartidas = new GestorPartidas();

    public Partida actualizarTableroInvocar(DataInvocar data) throws Exception {
        try {
            Partida partida = gPartidas.obtenerPartidaById(data.getIdPartida());

            if (partida == null) {
                throw new BussinessException(300);
            } else {
                int index;
                Personaje pj = gpersonajes.CrearPersonaje(data.getIdJugador());

                ArrayList<Casilla> casillas = new ArrayList<Casilla>();

                for (Casilla cas : data.getCasillasModificadas()) {
                    Optional<Casilla> obj;
                    obj = partida.getTablero().getCasillas().stream().filter(e -> e.getId() == cas.getId()).findFirst();

                    if (obj.isPresent()) {
                        index = partida.getTablero().getCasillas().indexOf(obj.get());
                        if (index > -1) {
                            partida.getTablero().getCasillas().set(index, cas);
                        }

                    }
                }

            }

        } catch (Exception e) {
            throw e;
        }
        return null;
    }

}
