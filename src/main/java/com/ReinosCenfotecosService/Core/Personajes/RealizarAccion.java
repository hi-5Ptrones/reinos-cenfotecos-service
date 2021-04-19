package com.ReinosCenfotecosService.Core.Personajes;

import com.ReinosCenfotecosService.Entities.Accion;
import com.ReinosCenfotecosService.Entities.Casilla;
import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.exceptions.BussinessException;

public abstract class RealizarAccion {
    RealizarAccion handler;

    public void setAccionHandler(RealizarAccion accionHandler){
        this.handler = accionHandler;
    }

    public abstract void faseDeAccion(Personaje objPersonajeAplica, Personaje objPersonajeAplicar,
                                      String[] casillas, String accionRealizar) throws BussinessException;
}
