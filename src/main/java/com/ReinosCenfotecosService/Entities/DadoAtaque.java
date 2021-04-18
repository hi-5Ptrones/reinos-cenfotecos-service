package com.ReinosCenfotecosService.Entities;

import com.ReinosCenfotecosService.Core.Cofre.ICofre;
import java.util.ArrayList;

public class DadoAtaque extends Dado {

    private AtaqueNormal ataquenormal;

    public DadoAtaque() {
    };
    
    public DadoAtaque(AtaqueNormal an) {

        this.ataquenormal = an;
    }

    public DadoAtaque(AtaqueNormal ataquenormal, int id, int valor) {
        super(id, "AtaqueNormal", valor);
        this.ataquenormal = ataquenormal;
    }
    

    public AtaqueNormal getAtaquenormal() {
        return ataquenormal;
    }

    public void setAtaquenormal(AtaqueNormal ataquenormal) {
        this.ataquenormal = ataquenormal;
    }

}
