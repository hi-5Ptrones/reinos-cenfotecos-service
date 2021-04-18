package com.ReinosCenfotecosService.Core.Dados;

import com.ReinosCenfotecosService.Entities.AtaqueEspecial;
import com.ReinosCenfotecosService.Entities.AtaqueNormal;
import com.ReinosCenfotecosService.Helper.Helper;

import java.util.ArrayList;


public class GestorPrototype {
    private static ArrayList<PrototipoDado> arrDados = new ArrayList<PrototipoDado>();

    private PrototipoDado protipoDado;
    private static AtaqueNormal an = new AtaqueNormal();
    private static AtaqueEspecial ae = new AtaqueEspecial();

    public GestorPrototype(int pId) {
        //crea el que se va a clonar
        protipoDado = new Dados(pId, "Invocacion", 3, an, ae, 0);
    }

    public String nuevos_dados(String pDado, int id) {
        String msj = "";

        arrDados.add(protipoDado.clone());

        //vamos a buscar los Id de los militantes y ponerlos en el DNI
        updateCloneDados(pDado, id);

        msj = "Dado "+(id+1)+" creado";

        return msj;
    }

    private static void updateCloneDados(String pDado, int id) {

        PrototipoDado cc = arrDados.get(id);

        //Cambiamos de atributos id,nombre, profesion, campamento,nave
        cc.setDado(id);
        cc.setTipo(pDado);
        cc.setValor(Helper.ramdomizeCantMovimientos());
        cc.setAn(an);

        //valorAE
        if (pDado.equals("AtaqueEspecial")) {
            ae.setNombre(Helper.ramdomizeAtaquesEspeciales());
            cc.setAe(ae);
        }

        //valorCantMovs
        if (pDado.equals("Movimiento")) {
            cc.setCantMovimientos(Helper.ramdomizeCantMovimientos());
        }
        ae = new AtaqueEspecial();
    }

    /**
     * **********************************************************
     * Metodo:	obtenerDatos
     * <p>
     * Descripción:	Obtiene los datos de los objetos del arreglo y los devuelve
     * en una variable.
     * <p>
     * Parametros:	pid [int] id del arreglo.
     *
     * @return: mResult [String]
     * ***********************************************************
     */
    public String obtenerDatos(int pid) {
        return obtenerDatosObjeto(arrDados.get(pid)) + "\n";
    }

    /**
     * **********************************************************
     * Metodo:	obtenerDatos
     * <p>
     * Descripción:	Obtiene los datos de las identificaciones y los devuelve en
     * una variable.
     * <p>
     * Parametros:	N/A
     *
     * @return: mResult [String]
     * ***********************************************************
     */
    public String obtenerDatos() {
        String mResult = "";
        for (PrototipoDado mOb : arrDados) {
            mResult += obtenerDatosObjeto(mOb) + "\n";
        }

        return mResult;
    }

    /**
     * ************************************************************
     * Metodo:	obtenerDatosObjeto
     * <p>
     * Descripción:	Obtiene los datos de un objeto en especifico
     * <p>
     * Parametros:	pObj [PrototipoDado]
     *
     * @return: mResult [String]
     * ***********************************************************
     */
    private String obtenerDatosObjeto(PrototipoDado pObj) {
        return pObj.getData() + "\n";
    }

    public void limpiarLista() {
        arrDados.clear();
    }
}
