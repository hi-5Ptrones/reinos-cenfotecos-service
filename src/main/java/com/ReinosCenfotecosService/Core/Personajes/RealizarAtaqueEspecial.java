package com.ReinosCenfotecosService.Core.Personajes;

import com.ReinosCenfotecosService.Entities.Accion;
import com.ReinosCenfotecosService.Entities.Casilla;
import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.exceptions.BussinessException;

public class RealizarAtaqueEspecial extends RealizarAccion{

    @Override
    public void faseDeAccion(Personaje objPersonajeAplica, Personaje objPersonajeAplicar, String[] casillas, String accionRealizar) throws BussinessException {
        if(accionRealizar == "AtacandoEspecial"){

        }else{
            if(handler != null){
                handler.faseDeAccion(objPersonajeAplica, objPersonajeAplicar, casillas, accionRealizar);
            }else{
                throw new BussinessException(507);
            }
        }
    }
}
