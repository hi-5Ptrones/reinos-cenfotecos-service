/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.Partida;

import com.ReinosCenfotecosService.Entities.Jugador;
import com.ReinosCenfotecosService.Entities.Partida;
import com.ReinosCenfotecosService.Helper.Helper;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;
import java.util.Optional;
import java.util.ArrayList;

import java.util.Random;

/**
 *
 * @author jorge
 */
public class GestorPartidas {

    protected static ArrayList<Partida> partidas = new ArrayList<Partida>();
    private DirectorPartida objDirector = new DirectorPartida();

    private Jugador construcionJugador(String nombre, int rowCastillo, int columnCastillo, int color) {
        objDirector.setBuilderJugador(new ConstructorJugador());
        return crearJugador(nombre, rowCastillo, columnCastillo, color);
        //objDirector.construirJugador(getIdJugador(), nombre, rowCastillo, columnCastillo);
    }

    private Jugador crearJugador(String nombre, int rowCastillo, int columnCastillo, int color) {
        objDirector.construirJugador(getIdJugador(), nombre, rowCastillo, columnCastillo, color);
        return objDirector.getBuilderJugador().getObjeto();
    }

    private int getIdJugador() {
        int idR = Helper.creadorDeIdentificacion();
        return idR;
    }

    private int getIdPartida() {
        int idR;
        boolean valid = false;
        do {
            idR = Helper.creadorDeIdentificacion();

            if (obtenerPartidaById(idR) == null) {
                valid = true;
            }
        } while (!valid);

        return idR;

    }

    public Partida obtenerPartidaById(int id) {

        Optional<Partida> obj;
        obj = partidas.stream().filter(e -> e.getId() == id).findFirst();
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }

    }

    public Partida construcionPartida(String nombre1, String nombre2, int ganador) throws Exception {
        try {
            objDirector.setBuilderTablero(new ConstructorTablero());
            //generar campo random para castillos
            int row1 = 0, col1, row2 = 19, col2, color1, color2;
            Random random = new Random();
            col1 = random.nextInt(9999 - 1000) + 1000;
            col2 = random.nextInt(9999 - 1000) + 1000;

            if (ganador == 1) {
                color1 = 1;
                color2 = 2;
            } else {
                color1 = 2;
                color2 = 1;
            }

            Jugador jug1 = construcionJugador(nombre1, row1, col1, color1);
            Jugador jug2 = construcionJugador(nombre2, row2, col2, color2);
            Partida par;
            objDirector.setBuilderPartida(new ConstructorPartida());
            par = crearPartida(jug1, jug2);

            return par;
        } catch (Exception e) {
            ExceptionManager.GetInstance().Process(e);

        }
        return null;
    }

    private Partida crearPartida(Jugador jug1, Jugador jug2) {
        objDirector.construirPartida(getIdPartida(), jug1, jug2, getIdJugador());
        return objDirector.getBuilderPartida().getObjeto();
    }
}
