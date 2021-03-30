/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.AtaqueEspecial;

import com.ReinosCenfotecosService.Entities.AEAtaqueBomba;
import com.ReinosCenfotecosService.Entities.AEAtaqueDistancia;
import com.ReinosCenfotecosService.Entities.AEBufferAtaque;
import com.ReinosCenfotecosService.Entities.AEBufferDefensa;
import com.ReinosCenfotecosService.Entities.AEDebuffAoE;
import com.ReinosCenfotecosService.Entities.AEHealerlvl1;
import com.ReinosCenfotecosService.Entities.AEHealerlvl2;
import com.ReinosCenfotecosService.Entities.AEProteccionEquivalente;
import com.ReinosCenfotecosService.Entities.AESacrificarVidaxMovimiento;
import com.ReinosCenfotecosService.Entities.Artillero;
import com.ReinosCenfotecosService.Entities.AtaqueEspcecial;
import com.ReinosCenfotecosService.Entities.Infanteria;
import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.Entities.Tanque;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;

/**
 *
 * @author jscru
 */
public class GestorAtaqueEspecial {

    Personaje objPersonajeAtacando = null;

    public void asignarAtaqueEspcial(AtaqueEspcecial specialAtack) throws BussinessException, Exception {
        try {
            if (objPersonajeAtacando instanceof Infanteria) {
                switch (specialAtack.getNombre()) {
                    case "Altar del guardián":
                        objPersonajeAtacando = new AEHealerlvl1(objPersonajeAtacando);
                        break;
                    case "Plegaria":
                        objPersonajeAtacando = new AEHealerlvl2(objPersonajeAtacando);
                        break;
                    case "Horno del alma":
                        objPersonajeAtacando = new AEBufferAtaque(objPersonajeAtacando);
                        break;
                    case "Refugio del espiritu":
                        objPersonajeAtacando = new AEBufferDefensa(objPersonajeAtacando);
                        break;
                }
            } else if (objPersonajeAtacando instanceof Artillero) {
                switch (specialAtack.getNombre()) {
                    case "Embate imparable":
                        objPersonajeAtacando = new AEAtaqueDistancia(objPersonajeAtacando);
                        break;
                    case "Indestuctrible":
                        objPersonajeAtacando = new AEBufferAtaque(objPersonajeAtacando);
                        break;
                    case "Heraldo de la Destrucción":
                        objPersonajeAtacando = new AEBufferDefensa(objPersonajeAtacando);
                        break;
                }
            } else if (objPersonajeAtacando instanceof Tanque) {
                switch (specialAtack.getNombre()) {
                    case "Descarga de Adrenalina ":
                        objPersonajeAtacando = new AESacrificarVidaxMovimiento(objPersonajeAtacando);
                        break;
                    case "Gloria en la muerte":
                        objPersonajeAtacando = new AEAtaqueBomba(objPersonajeAtacando);
                        break;
                    case "Embajador de Hierro":
                        objPersonajeAtacando = new AEProteccionEquivalente(objPersonajeAtacando);
                        break;
                    case "Tormenta Creciente ":
                        objPersonajeAtacando = new AEDebuffAoE(objPersonajeAtacando);
                        break;
                }
            } else {
                throw new BussinessException(501);
            }
        } catch (BussinessException bex) {
            ExceptionManager.GetInstance().Process(bex);
        }

    }
    
    public void finalizacionAtaqueEspecial(){
        AsbtractClassEvolucion personajeAtacando = (AsbtractClassEvolucion)objPersonajeAtacando;
        Personaje estadoBase = personajeAtacando.getEstadoBasePersonaje();
    }
}
