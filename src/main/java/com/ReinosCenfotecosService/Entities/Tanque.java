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
public class Tanque extends Personaje {

    @Override
    public void setEstadisticasPersonaje() {
        this.setAtaque(0);
        this.setDefensa(0);
        this.setMovsMaximos(0);
        this.setVida(0);
        this.setTipoPersonaje("Tanque");
    }

    @Override
    public String getInfoPersonaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
