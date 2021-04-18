/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.Cofre;

import com.ReinosCenfotecosService.Core.Partida.GestorPartidas;
import com.ReinosCenfotecosService.Entities.AtaqueEspecial;
import com.ReinosCenfotecosService.Entities.Cofre;
import com.ReinosCenfotecosService.Entities.Dado;
import com.ReinosCenfotecosService.Entities.DadoAtaque;
import com.ReinosCenfotecosService.Entities.DadoAtaqueEspecial;
import com.ReinosCenfotecosService.Entities.DadoInvocacion;
import com.ReinosCenfotecosService.Entities.DadoMovimiento;
import com.ReinosCenfotecosService.Entities.Jugador;
import com.ReinosCenfotecosService.Entities.Partida;
import java.util.ArrayList;

/**
 *
 * @author guiss
 */
public class GestorCofre {

    private GestorPartidas gesPartidas = new GestorPartidas();
    private ArrayList<Cofre> cofres = new ArrayList<Cofre>();

    Cofre cofre;

    public ArrayList<ICofre> nuevo_cofre_Dado(ArrayList<Dado> dados, int idPartida, int jugador) {
        Partida objPartida = gesPartidas.obtenerPartidaById(idPartida);

        if (objPartida != null) {
            if (jugador == 1) {
                cofre = objPartida.getJugador1().getCofre();
                for (ICofre nodo : dados) {

                    cofre.agregarComponente(nodo);
                }
                cofre.ejecutar();
            }
        } else if (jugador == 2) {

            cofre = objPartida.getJugador2().getCofre();
            for (ICofre nodo : dados) {

                cofre.agregarComponente(nodo);
            }
            cofre.ejecutar();
        }

        return cofre.getListaComposicion();
    }

    public ArrayList<ICofre> quitar_cofre_Dado(ArrayList<Dado> dados, int idPartida, int jugador) {
        Partida objPartida = gesPartidas.obtenerPartidaById(idPartida);

        if (objPartida != null) {
            if (jugador == 1) {
                cofre = objPartida.getJugador1().getCofre();
                for (ICofre nodo : dados) {
                    if (nodo instanceof Dado) {
                        Dado da = (Dado) nodo;
                        int indice = 0;
                        indice = cofre.getListaComposicion().indexOf(da);
                        cofre.quitarComponente(indice);
                    }
                }
                cofre.ejecutar();
            }
        } else if (jugador == 2) {

            cofre = objPartida.getJugador2().getCofre();
            for (ICofre nodo : dados) {
                if (nodo instanceof Dado) {
                    Dado da = (Dado) nodo;
                    int indice = 0;
                    indice = cofre.getListaComposicion().indexOf(da);
                    cofre.quitarComponente(indice);
                }
            }
            cofre.ejecutar();
        }

        return cofre.getListaComposicion();
    }

}