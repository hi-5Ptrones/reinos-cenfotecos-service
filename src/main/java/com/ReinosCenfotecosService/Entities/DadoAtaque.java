package com.ReinosCenfotecosService.Entities;

public class DadoAtaque extends Dado{
    private AtaqueNormal ataquenormal;
    
    public DadoAtaque(){};
    
    public DadoAtaque(AtaqueNormal an){
    
        this.ataquenormal = an;
    }

    public AtaqueNormal getAtaquenormal() {
        return ataquenormal;
    }

    public void setAtaquenormal(AtaqueNormal ataquenormal) {
        this.ataquenormal = ataquenormal;
    }
    
   
}
