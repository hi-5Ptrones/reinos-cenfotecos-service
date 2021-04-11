/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.Personajes;

import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;

/**
 *
 * @author jscru
 */
public class GestorPersonajes {

    public Personaje CrearPersonaje(int tpersonaje) throws BussinessException, Exception {
        Personaje responseMessage = null;
        try {
            if (tpersonaje < 1 || tpersonaje > 3) {
                throw new BussinessException(500);
            } else {

                FactoryPersonaje factory = new FactoryPersonaje();
                Personaje objPersonaje = factory.crearPersonaje(tpersonaje);

                responseMessage =objPersonaje;

            }
        } catch (BussinessException bex) {
            ExceptionManager.GetInstance().Process(bex);
        }
        return responseMessage;
    }
}
