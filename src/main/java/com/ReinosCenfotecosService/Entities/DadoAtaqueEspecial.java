package com.ReinosCenfotecosService.Entities;

import com.ReinosCenfotecosService.Core.Cofre.ICofre;
import java.util.ArrayList;

public class DadoAtaqueEspecial extends Dado {

    private AtaqueEspecial ataqueEspecial;

    public DadoAtaqueEspecial() {
    }
    
    public DadoAtaqueEspecial(AtaqueEspecial ae) {
        this.ataqueEspecial = ae;

    }

    public DadoAtaqueEspecial(AtaqueEspecial ataqueEspecial, int id, int valor) {
        super(id, "AtaqueEspecial ", valor);
        this.ataqueEspecial = ataqueEspecial;
    }

    public AtaqueEspecial getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(AtaqueEspecial ae) {
        this.ataqueEspecial = ae;
    }

}
