/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Entities;

import java.util.ArrayList;

/**
 *
 * @author jscru
 */
public class Cofre {

    private ArrayList<DadoInvocacion> listDadosInvocacion;
    private ArrayList<DadoAccion> listDadosMovimiento;
    private ArrayList<DadoAccion> listDadosAtaque;
    private ArrayList<DadoAccion> listDadosAtaqueEspecial;

    public Cofre() {
        listDadosInvocacion = new ArrayList<DadoInvocacion>();
        listDadosMovimiento = new ArrayList<DadoAccion>();
        listDadosAtaque = new ArrayList<DadoAccion>();
        listDadosAtaqueEspecial = new ArrayList<DadoAccion>();
    }

}
