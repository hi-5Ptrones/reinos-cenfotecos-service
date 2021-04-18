package com.ReinosCenfotecosService.Entities;

import com.ReinosCenfotecosService.Core.Cofre.ICofre;
import java.util.ArrayList;

public class DadoInvocacion extends Dado{
    private String tipoInvocacion;

    public DadoInvocacion() {
    }

    public DadoInvocacion(String tipoInvocacion, int id, int valor) {
        super(id, "DadoInvocacion", valor);
        this.tipoInvocacion = tipoInvocacion;
    }

    public String getTipoInvocacion() {
        return tipoInvocacion;
    }

    public void setTipoInvocacion(String tipoInvocacion) {
        this.tipoInvocacion = tipoInvocacion;
    }
    
  
}
