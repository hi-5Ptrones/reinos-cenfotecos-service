package com.ReinosCenfotecosService.Core.Observador;

import java.io.Serializable;

public interface Observador {
    void update(Serializable value, String nombre);

}