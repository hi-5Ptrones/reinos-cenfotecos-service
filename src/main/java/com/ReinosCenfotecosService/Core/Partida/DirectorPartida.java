/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.Partida;

import com.ReinosCenfotecosService.Entities.Casilla;
import com.ReinosCenfotecosService.Entities.Jugador;
import com.ReinosCenfotecosService.Entities.Tablero;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jorge
 */
public class DirectorPartida {

    private BuilderPartida builderPartida;
    private BuilderJugador builderJugador;
    //private BuilderCofre builderCofre;
    private BuilderTablero builderTablero;

    public DirectorPartida() {
    }

    public void construirPartida(int id, Jugador jugador1, Jugador jugador2, int idTablero) {
        builderPartida.crearNuevo();
        construirTablero(idTablero, id);
        builderPartida.construir(id, jugador1, jugador2, getBuilderTablero().getObjeto(), 0, new Date().toString(), 1, 0, 1);

    }

    public void construirTablero(int id, int idPartida) {
        builderTablero.crearNuevo();
        builderTablero.construir(id, idPartida);
        ArrayList<Casilla> casillas = new ArrayList<Casilla>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                casillas.add(new Casilla(Integer.parseInt(i + "" + j + "" + idPartida), id, i, j, null, 0, false));
            }
        }
        builderTablero.construirConCasillas(casillas);
    }

    public void construirJugador(int id, String nombre, int row, int column, int color) {
        builderJugador.crearNuevo();
        builderJugador.construir(id, nombre, 4, row, column,color, null);// aqui falta el cofre
    }

    public BuilderPartida getBuilderPartida() {
        return builderPartida;
    }

    public void setBuilderPartida(BuilderPartida builderPartida) {
        this.builderPartida = builderPartida;
    }

    public BuilderJugador getBuilderJugador() {
        return builderJugador;
    }

    public void setBuilderJugador(BuilderJugador builderJugador) {
        this.builderJugador = builderJugador;
    }

    public BuilderTablero getBuilderTablero() {
        return builderTablero;
    }

    public void setBuilderTablero(BuilderTablero builderTablero) {
        this.builderTablero = builderTablero;
    }

}
