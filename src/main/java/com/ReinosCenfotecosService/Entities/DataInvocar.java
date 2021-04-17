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
public class DataInvocar {

    private int idPersonaje;
    private int idPartida;
    private int idJugador;// ya sea el id o el color 1 0 2;
    private ArrayList<Casilla> casillasModificadas = new ArrayList<Casilla>();

    public DataInvocar() {
    }   
    
    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public ArrayList<Casilla> getCasillasModificadas() {
        return casillasModificadas;
    }

    public void setCasillasModificadas(ArrayList<Casilla> casillasModificadas) {
        this.casillasModificadas = casillasModificadas;
    }
    
    

}
