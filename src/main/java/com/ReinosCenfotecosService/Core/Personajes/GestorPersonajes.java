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

    private GestorPartidas gesParidas = new GestorPartidas();

    public Personaje CrearPersonaje(int tpersonaje, int idPartida, int jugador) throws BussinessException, Exception {
        Personaje responseMessage = null;
        try {
            if (tpersonaje < 1 || tpersonaje > 3) {
                throw new BussinessException(500);
            } else {

                FactoryPersonaje factory = new FactoryPersonaje();
                Personaje objPersonaje = factory.crearPersonaje(tpersonaje);
                responseMessage = objPersonaje;
                asignarPersonajeAJugador(objPersonaje, idPartida, jugador);

            }
        } catch (BussinessException bex) {
            ExceptionManager.GetInstance().Process(bex);
        }
        return responseMessage;
    }

    private void asignarPersonajeAJugador(Personaje objPersonaje, int idPartida, int idCurrentPlayer) {
        Partida objPartida = gesParidas.obtenerPartidaById(idPartida);
        if (objPartida != null) {
            int idPlayer1 = objPartida.getJugador1().getId();
            int idPlayer2 = objPartida.getJugador2().getId();

            if (idPlayer1 == idCurrentPlayer) {
                objPartida.getJugador1().addPJtoListPlayer(objPersonaje);
            } else if (idPlayer2 == idCurrentPlayer) {
                objPartida.getJugador2().addPJtoListPlayer(objPersonaje);
            } else {
                //tirar excepion
            }
        } else {
            //tirar excepion
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
