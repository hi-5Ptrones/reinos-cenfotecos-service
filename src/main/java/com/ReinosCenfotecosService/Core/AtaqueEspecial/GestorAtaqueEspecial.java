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
import com.ReinosCenfotecosService.Entities.Jugador;
import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.Entities.Tanque;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;

/**
 *
 * @author jscru
 */
public class GestorAtaqueEspecial {

    Jugador player;

    public GestorAtaqueEspecial() {
        player = new Jugador("123456", "Bryan");
        player.agregarPersonajealistadeJugador(new Infanteria());
        player.agregarPersonajealistadeJugador(new Infanteria());
        player.agregarPersonajealistadeJugador(new Artillero());
        player.agregarPersonajealistadeJugador(new Artillero());
        player.agregarPersonajealistadeJugador(new Tanque());
        player.agregarPersonajealistadeJugador(new Tanque());
    }

    public void asignarAtaqueEspcial(AtaqueEspcecial specialAtack, int idPersonajeAplica,
            int idPersonajeaAplicar) throws BussinessException, Exception {
        Personaje objPersonajeAplica = null;
        Personaje objPersonajeaAplicar = null;
        
         
        try {
            if (objPersonajeAplica instanceof Infanteria) {
                switch (specialAtack.getNombre()) {
                    case "Altar del guardián":
                        new AEHealerlvl1(objPersonajeaAplicar);                        
                        break;
                    case "Plegaria":
                        new AEHealerlvl2(objPersonajeaAplicar);
                        break;
                    case "Horno del alma":
                        new AEBufferAtaque(objPersonajeaAplicar);
                        break;
                    case "Refugio del espiritu":
                        new AEBufferDefensa(objPersonajeaAplicar);
                        break;
                    default:
                        throw new BussinessException(502);
                }
            } else if (objPersonajeAplica instanceof Artillero) {
                switch (specialAtack.getNombre()) {
                    case "Embate imparable":
                        new AEAtaqueDistancia(objPersonajeaAplicar);
                        break;
                    case "Indestuctrible":
                        new AEBufferAtaque(objPersonajeaAplicar);
                        break;
                    case "Heraldo de la Destrucción":
                        new AEBufferDefensa(objPersonajeaAplicar);
                        break;
                }
            } else if (objPersonajeAplica instanceof Tanque) {
                switch (specialAtack.getNombre()) {
                    case "Descarga de Adrenalina ":
                        new AESacrificarVidaxMovimiento(objPersonajeaAplicar);
                        break;
                    case "Gloria en la muerte":
                        new AEAtaqueBomba(objPersonajeaAplicar);
                        break;
                    case "Embajador de Hierro":
                        new AEProteccionEquivalente(objPersonajeaAplicar);
                        break;
                    case "Tormenta Creciente ":
                        new AEDebuffAoE(objPersonajeaAplicar);
                        break;
                }
            } else {
                throw new BussinessException(501);
            }
        } catch (BussinessException bex) {
            ExceptionManager.GetInstance().Process(bex);
        }
    }

//    public void finalizacionAtaqueEspecial() {
//        AsbtractClassEvolucion personajeAtacando = (AsbtractClassEvolucion) objPersonajeAtacando;
//        Personaje estadoBase = personajeAtacando.getEstadoBasePersonaje();
//    }
}
