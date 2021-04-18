/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Entities;

import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class Tablero {
    private int id;
    private int idPartida;
    private ArrayList<ArrayList<Casilla>> casillas;

    public Tablero() {
    }

    public Tablero(int id, int idPartida, ArrayList<ArrayList<Casilla>> casillas) {
        this.id = id;
        this.idPartida = idPartida;
        this.casillas = casillas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public ArrayList<ArrayList<Casilla>> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<ArrayList<Casilla>> casillas) {
        this.casillas = casillas;
    }
    
}
