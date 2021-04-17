/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.Personajes;

import com.ReinosCenfotecosService.Core.Partida.GestorPartidas;
import com.ReinosCenfotecosService.Entities.Partida;
import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;

/**
 * @author jscru
 */
public class GestorPersonajes {

    private GestorPartidas gesPartidas = new GestorPartidas();
    public Personaje CrearPersonaje(int tpersonaje, int idPartida, int jugador, String coordenadas) throws BussinessException, Exception {
        Personaje responseMessage = null;
        try {
            if (tpersonaje < 1 || tpersonaje > 3) {
                throw new BussinessException(500);
            } else {

                FactoryPersonaje factory = new FactoryPersonaje();
                Personaje objPersonaje = factory.crearPersonaje(tpersonaje);
                responseMessage = objPersonaje;
                asignarPersonajeAJugador(objPersonaje, idPartida, jugador, coordenadas);

            }
        } catch (BussinessException bex) {
            ExceptionManager.GetInstance().Process(bex);
        }
        return responseMessage;
    }

    private void asignarPersonajeAJugador(Personaje objPersonaje, int idPartida, int currectPlayer, String coordenadas) throws BussinessException {
        Partida objPartida = gesPartidas.obtenerPartidaById(idPartida);
        String coords[] = new String[2];
        int row, coll;
        coords = coordenadas.split("-");
        row = Integer.parseInt(coords[0]);
        coll = Integer.parseInt(coords[1]);
        if (objPartida != null) {

            if (currectPlayer == 1) {
                objPartida.getJugador1().addPJtoListPlayer(objPersonaje);
            } else if (currectPlayer == 2) {
                objPartida.getJugador2().addPJtoListPlayer(objPersonaje);

            } else {
                throw new BussinessException(505);
            }
        } else {
            throw new BussinessException(504);
        }
    }


    public Object saveCurrentPoscitionCharacter(int idPersonaje, String lastCoords) throws BussinessException, Exception {
        try {
            if (true) {
                throw new BussinessException(500);
            } else {

            }
        } catch (BussinessException bex) {
            ExceptionManager.GetInstance().Process(bex);
        }
        return "";
    }


    public Object validateNewPosCharacter(int idPersonaje, String newCoords) throws BussinessException, Exception {
        try {
            if (true) {
                throw new BussinessException(500);
            } else {

            }
        } catch (BussinessException bex) {
            ExceptionManager.GetInstance().Process(bex);
        }
        return "";
    }
}
