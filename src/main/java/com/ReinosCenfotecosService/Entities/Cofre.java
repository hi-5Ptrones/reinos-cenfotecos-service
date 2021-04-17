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

    static int classCounter = 0;
    int id;
    private ArrayList<DadoInvocacion> listDadosInvocacion;
    private ArrayList<DadoAtaque> listDadosMovimiento;
    private ArrayList<DadoAtaque> listDadosAtaque;
    private ArrayList<DadoAtaque> listDadosAtaqueEspecial;

    public Cofre() {
        listDadosInvocacion = new ArrayList<DadoInvocacion>();
        listDadosMovimiento = new ArrayList<DadoAccion>();
        listDadosAtaque = new ArrayList<DadoAccion>();
        listDadosAtaqueEspecial = new ArrayList<DadoAccion>();
        this.id = classCounter = 0;
    }

    public ArrayList<DadoInvocacion> getListDadosInvocacion() {
        return listDadosInvocacion;
    }

    public void setListDadosInvocacion(ArrayList<DadoInvocacion> listDadosInvocacion) {
        this.listDadosInvocacion = listDadosInvocacion;
    }

    public ArrayList<DadoAccion> getListDadosMovimiento() {
        return listDadosMovimiento;
    }

    public void setListDadosMovimiento(ArrayList<DadoAccion> listDadosMovimiento) {
        this.listDadosMovimiento = listDadosMovimiento;
    }

    public ArrayList<DadoAccion> getListDadosAtaque() {
        return listDadosAtaque;
    }

    public void setListDadosAtaque(ArrayList<DadoAccion> listDadosAtaque) {
        this.listDadosAtaque = listDadosAtaque;
    }

    public ArrayList<DadoAccion> getListDadosAtaqueEspecial() {
        return listDadosAtaqueEspecial;
    }

    public void setListDadosAtaqueEspecial(ArrayList<DadoAccion> listDadosAtaqueEspecial) {
        this.listDadosAtaqueEspecial = listDadosAtaqueEspecial;
    }

    public int getId() {
        return id;
    }

}
