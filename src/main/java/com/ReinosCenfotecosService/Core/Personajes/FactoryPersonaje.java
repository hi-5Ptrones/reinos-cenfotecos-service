/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.Personajes;

import com.ReinosCenfotecosService.Entities.Artillero;
import com.ReinosCenfotecosService.Entities.Infanteria;
import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.Entities.Tanque;

/**
 *
 * @author jscru
 */
public class FactoryPersonaje implements IAbstractFactoryMethodPersonaje {

    @Override
    public Personaje crearPersonaje(int tPersonaje) {
        Personaje objPersonaje = null;
        switch (tPersonaje) {
            case 1:
                objPersonaje = new Artillero();
                break;
            case 2:
                objPersonaje = new Infanteria();
                break;
            case 3:
                objPersonaje = new Tanque();
                break;
            default:
                break;
        }
        return objPersonaje;
    }

}
