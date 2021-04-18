
package com.ReinosCenfotecosService.Entities;

import com.ReinosCenfotecosService.Core.Cofre.ICofre;
import java.util.ArrayList;

public class DadoMovimiento extends Dado{
     
    private int cantMovimientos;

    public DadoMovimiento() {
    }

    public DadoMovimiento(int id, int valor) {
        super(id, "DadoMovimiento", valor);
    }

    public DadoMovimiento(int cantMovimientos, int id, int valor) {
        super(id, "DadoMovimiento", valor);
        this.cantMovimientos = cantMovimientos;
    }

    public int getCantMovimientos() {
        return cantMovimientos;
    }

    public void setCantMovimientos(int cantMovimientos) {
        this.cantMovimientos = cantMovimientos;
    }

}
