/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Entities;

import com.ReinosCenfotecosService.Core.Cofre.ICofre;
import java.util.ArrayList;

/**
 *
 * @author jscru
 */
public class Cofre implements ICofre {

    private ArrayList<ICofre> listaComposicion; //Contiene los dados
    private int id;
    private static int classCounter = 0;
    
    public Cofre() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ICofre> mostrarDatos() {
        return listaComposicion;
    }

    public void agregarComponente(ICofre composicion) {
        this.listaComposicion.add(composicion);
    }
    public void quitarComponente(int  indice) {
        this.listaComposicion.remove(indice);
    }

    public ArrayList<ICofre> getListaComposicion() {
        return listaComposicion;
    }

    public void setListaComposicion(ArrayList<ICofre> listaComposicion) {
        this.listaComposicion = listaComposicion;
    }

    @Override
    public String ejecutar() {
        String data = "";

        for (ICofre nodo : listaComposicion) {
            data += nodo.ejecutar();
        }
        return data;
    }

}
