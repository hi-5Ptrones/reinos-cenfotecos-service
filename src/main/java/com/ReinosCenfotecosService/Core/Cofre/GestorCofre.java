/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Core.Cofre;

import com.ReinosCenfotecosService.Entities.AtaqueEspecial;
import com.ReinosCenfotecosService.Entities.Cofre;
import com.ReinosCenfotecosService.Entities.Dado;
import com.ReinosCenfotecosService.Entities.DadoAtaque;
import com.ReinosCenfotecosService.Entities.DadoAtaqueEspecial;
import com.ReinosCenfotecosService.Entities.DadoInvocacion;
import com.ReinosCenfotecosService.Entities.DadoMovimiento;
import com.ReinosCenfotecosService.Entities.Jugador;
import java.util.ArrayList;

/**
 *
 * @author guiss
 */
public class GestorCofre {

    private ArrayList<Cofre> cofres = new ArrayList<Cofre>();

    Cofre cofre;

    public ArrayList<ICofre> nuevo_cofre_Dado(ArrayList<Dado> dados, Jugador jugador) {
        //Se espera envíen los dados y el jugador
        /*ArrayList<Dado> dados = new ArrayList<Dado>();
       
        AtaqueEspecial ae = new AtaqueEspecial();
        ae.setNombre("AtaqueEspecial (Nombre)");
        ae.setDescripcion("?");
        Dado d1 = new DadoAtaqueEspecial(ae, 1, 1);
        dados.add(d1);*/

        cofre = jugador.getCofre();

        for (ICofre nodo : dados) {
            cofre.agregarComponente(nodo);
        }
        cofre.ejecutar();
        
        return cofre.getListaComposicion(); 
    }

}
