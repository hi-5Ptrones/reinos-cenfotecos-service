package com.ReinosCenfotecosService.Core.Patron_Prototype.iProtitpo;

import com.ReinosCenfotecosService.Entities.AtaqueEspcecial;
import com.ReinosCenfotecosService.Entities.AtaqueNormal;



public abstract class PrototipoDado {
    private int dado;
    private String tipo;
    private int valor;
    private AtaqueEspcecial ae;
    private AtaqueNormal an;
    private int cantMovimientos;

    public abstract PrototipoDado clone();

    //Gets and Sets

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public AtaqueEspcecial getAe() {
        return ae;
    }

    public void setAe(AtaqueEspcecial ae) {
        this.ae = ae;
    }

    public AtaqueNormal getAn() {
        return an;
    }

    public void setAn(AtaqueNormal an) {
        this.an = an;
    }

    public int getCantMovimientos() {
        return cantMovimientos;
    }

    public void setCantMovimientos(int cantMovimientos) {
        this.cantMovimientos = cantMovimientos;
    }

    


  

    public String getData() {
        String mData = "< Dado >\n";

        mData += "De tipo: " + this.getTipo()+ "\n";
        
        if(this.getCantMovimientos() != 0){
        mData += "Movs: " + this.getCantMovimientos()+ "\n";
        }
        if((ae.getNombre() != null)){
        mData += "Ataque especial: " + this.ae.getNombre()+ "\n";
        }
        return mData;
    }
}
