package com.ReinosCenfotecosService.Entities;

public class DadoAtaqueEspecial extends Dado{
    private AtaqueEspcecial ataqueEspecial;
    
    public DadoAtaqueEspecial(){};
    
    public DadoAtaqueEspecial(AtaqueEspcecial ae){
        this.ataqueEspecial = ae;
        
    }

    public AtaqueEspcecial getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(AtaqueEspcecial ae) {
        this.ataqueEspecial = ae;
    }
}
