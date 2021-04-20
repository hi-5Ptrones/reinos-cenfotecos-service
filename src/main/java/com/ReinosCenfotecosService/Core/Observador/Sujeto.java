package com.ReinosCenfotecosService.Core.Observador;

import com.ReinosCenfotecosService.Entities.Partida;

public interface Sujeto {
    Partida addObserver(Observador o);

    Partida removeObserver(Observador o);

    Partida notifyObservers();
}