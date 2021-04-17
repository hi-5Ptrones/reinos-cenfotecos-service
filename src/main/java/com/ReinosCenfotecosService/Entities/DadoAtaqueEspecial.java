package com.ReinosCenfotecosService.Entities;

public class DadoAtaqueEspecial extends Dado{
    private AtaqueEspecial ataqueEspecial;
    
    public DadoAtaqueEspecial(){};
    
    public DadoAtaqueEspecial(AtaqueEspecial ae){
        this.ataqueEspecial = ae;
        
    }

    public AtaqueEspecial getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(AtaqueEspecial ae) {
        this.ataqueEspecial = ae;
    }
}
