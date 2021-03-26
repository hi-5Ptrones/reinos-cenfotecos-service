/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Entities;

/**
 *
 * @author jscru
 */
public abstract class Personaje {

    private int id;
    private int vida;
    private int ataque;
    private int defensa;
    private int movsMaximos;

    public Personaje() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getMovsMaximos() {
        return movsMaximos;
    }

    public void setMovsMaximos(int movsMaximos) {
        this.movsMaximos = movsMaximos;
    }

    public abstract void setEstadisticasPersonaje();

    public abstract String getInfoPersonaje();

}
