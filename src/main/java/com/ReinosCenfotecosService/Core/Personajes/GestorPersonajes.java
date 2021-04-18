/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.Personajes;

import com.ReinosCenfotecosService.Core.Partida.GestorAcciones;
import com.ReinosCenfotecosService.Core.Partida.GestorPartidas;
import com.ReinosCenfotecosService.Entities.Casilla;
import com.ReinosCenfotecosService.Entities.DataInvocar;
import com.ReinosCenfotecosService.Entities.Partida;
import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.Helper.Helper;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;

import java.util.ArrayList;

/**
 * @author jscru
 */
public class GestorPersonajes {

    private GestorPartidas gesPartidas = new GestorPartidas();
    private GestorAcciones gesAcciones = new GestorAcciones();

    public Personaje CrearPersonaje(int tpersonaje, int idPartida, int jugador, String[] coordenadas) throws BussinessException, Exception {
        Personaje responseMessage = null;
        DataInvocar dataInvocacion = null;
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

    private void asignarPersonajeAJugador(Personaje objPersonaje, int idPartida, int currectPlayer, String[] coordenadas) throws Exception {
        Partida objPartida = gesPartidas.obtenerPartidaById(idPartida);
        int row, coll;
        int idTablero;
        int i = 0;
        if (objPartida != null) {
            if (currectPlayer == 1) {
                objPartida.getJugador1().addPJtoListPlayer(objPersonaje);
                for (String coord : coordenadas) {
                    String coords[] = coord.split("-");
                    row = Integer.parseInt(coords[0]);
                    coll = Integer.parseInt(coords[1]);
                    if (i == 0) {
                        idTablero = objPartida.getTablero().getId();
                        invocacionPJenTablero(objPersonaje.getId(), idTablero, currectPlayer, row, coll, objPersonaje, idPartida);
                    } else {
                        idTablero = objPartida.getTablero().getId();
                        invocacionPJenTablero(objPersonaje.getId(), idTablero, currectPlayer, row, coll, null, idPartida);
                    }
                    i++;
                }


            } else if (currectPlayer == 2) {
                objPartida.getJugador2().addPJtoListPlayer(objPersonaje);
                for (String coord : coordenadas) {
                    String coords[] = coord.split("-");
                    row = Integer.parseInt(coords[0]);
                    coll = Integer.parseInt(coords[1]);
                    if (i == 0) {
                        idTablero = objPartida.getTablero().getId();
                        invocacionPJenTablero(objPersonaje.getId(), idTablero, currectPlayer, row, coll, objPersonaje, idPartida);
                    } else {
                        idTablero = objPartida.getTablero().getId();
                        invocacionPJenTablero(objPersonaje.getId(), idTablero, currectPlayer, row, coll, null, idPartida);
                    }
                    i++;
                }
            } else {
                throw new BussinessException(505);
            }
        } else {
            throw new BussinessException(504);
        }
    }

    private void invocacionPJenTablero(int idPersonaje, int idTablero, int currectPlayer, int row,
                                       int coll, Personaje objPersonaje, int idPartida) throws Exception {
        Casilla casillaDeInvocacion = new Casilla(Helper.generarIdCasilla(row, coll, idTablero),
                idTablero, row, coll, objPersonaje, currectPlayer, true);
        ArrayList<Casilla> casillas = new ArrayList<Casilla>();
        casillas.add(casillaDeInvocacion);
        DataInvocar datInvocacion = new DataInvocar(idPersonaje, idPartida, currectPlayer, casillas);
        gesAcciones.actualizarTableroInvocar(datInvocacion);
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
