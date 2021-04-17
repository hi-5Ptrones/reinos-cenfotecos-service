package com.ReinosCenfotecosService.Core.Timer;

import java.util.HashMap;


public class Gestor_Observador {
    private HashMap<String, SujetoC> ListaProductos;

    public Gestor_Observador() {
        ListaProductos = new HashMap<String, SujetoC>();
    }

    public void NuevoProducto(String pKey) {
        ListaProductos.put(pKey, new SujetoC(pKey));
    }

    public void NuevoObservador(String pObservador, String pProducto) {
        ListaProductos.get(pProducto).addObserver(new ObservadorC(pObservador));
    }

    public void NuevoValor(String pProducto, int pValor) {
        ListaProductos.get(pProducto).setState2(pValor);
    }

    public void NuevoTiempo(String pProducto, int pTiempo) {
        ListaProductos.get(pProducto).setState(pTiempo);
    }
}
