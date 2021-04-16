package com.ReinosCenfotecosService.Core.Patron_Prototype.prototipo;

//agregar  naves,campamentos, nombre y profesion.

import com.ReinosCenfotecosService.Core.Patron_Prototype.iProtitpo.PrototipoDado;
import com.ReinosCenfotecosService.Entities.AtaqueEspcecial;
import com.ReinosCenfotecosService.Entities.AtaqueNormal;


public class Dados extends PrototipoDado {

    public Dados(int pDado, String pTipo, int pValor, AtaqueNormal pAN, AtaqueEspcecial pAE, int cantMovimientos) {
        this.setDado(pDado);
        this.setTipo(pTipo);
        this.setValor(pValor);
        this.setAn(pAN);
        this.setAe(pAE);
        this.setCantMovimientos(cantMovimientos);
        
    }

    @Override
    public PrototipoDado clone() {
        return new Dados(this.getDado(), this.getTipo(), this.getValor(), this.getAn(), this.getAe(), this.getCantMovimientos());
    }

}
