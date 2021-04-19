package com.ReinosCenfotecosService.Core.Dados;

import com.ReinosCenfotecosService.Entities.AtaqueEspecial;
import com.ReinosCenfotecosService.Entities.AtaqueNormal;


public abstract class PrototipoDado {
    private int id;
    private String tipo;
    private int cantMovimientos;

    public abstract PrototipoDado clone();

    //Gets and Sets

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getCantMovimientos() {
        return cantMovimientos;
    }

    public void setCantMovimientos(int cantMovimientos) {
        this.cantMovimientos = cantMovimientos;
    }


    public String getData() {
        String mData = "< Dado #"+(this.getId()+1)+">\n";

        mData += "De tipo: " + this.getTipo() + "\n";

        if (this.getCantMovimientos() != 0) {
            mData += "Movs: " + this.getCantMovimientos() + "\n";
        }
        return mData;
    }
}
