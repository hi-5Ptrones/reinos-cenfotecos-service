package com.ReinosCenfotecosService.Core.Personajes;

import com.ReinosCenfotecosService.Entities.Accion;
import com.ReinosCenfotecosService.Entities.Casilla;
import com.ReinosCenfotecosService.Entities.Personaje;

public abstract class RealizarAccion {
    RealizarAccion handler;

    public void setAccionHandler(RealizarAccion accionHandler){
        this.handler = accionHandler;
    }

    public abstract void faseDeAccion(Personaje objPersonajeAplica, Personaje objPersonajeAplicar,
                                      Casilla[] casillas, Accion accionRealizar);
}
