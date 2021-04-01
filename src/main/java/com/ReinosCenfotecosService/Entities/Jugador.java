/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Entities;

import java.util.ArrayList;

/**
 *
 * @author jscru
 */
public class Jugador {

    private String id;
    private String nombre;
    private int vidaCastillo;
    private ArrayList<Personaje> personajesEnJuego;

    public Jugador(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.vidaCastillo = 4;
        this.personajesEnJuego = new ArrayList<>();
    }

    public void agregarPersonajealistadeJugador(Personaje newPersonaje) {
        personajesEnJuego.add(newPersonaje);
    }

    public ArrayList<Personaje> getPersonajesEnJuego() {
        return personajesEnJuego;
    }

}
