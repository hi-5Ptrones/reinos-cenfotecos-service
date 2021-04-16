
package com.ReinosCenfotecosService.Entities;

public class DadoMovimiento extends Dado{
     
    private int cantMovimientos;

    public DadoMovimiento() {
    }

    public DadoMovimiento(int id, String tipo, int valor) {
        super(id, tipo, valor);
    }

    public int getCantMovimientos() {
        return cantMovimientos;
    }

    public void setCantMovimientos(int cantMovimientos) {
        this.cantMovimientos = cantMovimientos;
    }
    
}
