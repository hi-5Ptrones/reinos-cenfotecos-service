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
    private ArrayList<DadoAtaque> listDadosMovimiento;
    private ArrayList<DadoAtaque> listDadosAtaque;
    private ArrayList<DadoAtaque> listDadosAtaqueEspecial;

    public Cofre() {
        listDadosInvocacion = new ArrayList<DadoInvocacion>();
        listDadosMovimiento = new ArrayList<DadoAtaque>();
        listDadosAtaque = new ArrayList<DadoAtaque>();
        listDadosAtaqueEspecial = new ArrayList<DadoAtaque>();
    }

}
