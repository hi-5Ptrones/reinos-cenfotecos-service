package com.ReinosCenfotecosService.Core.Personajes;

import com.ReinosCenfotecosService.Entities.Personaje;
import com.ReinosCenfotecosService.exceptions.BussinessException;

public class RealizarMovimiento extends RealizarAccion {

    @Override
    public void faseDeAccion(Personaje objPersonajeAplica, Personaje objPersonajeAplicar, String[] casillas, String accionRealizar) throws BussinessException {
        boolean estadoValidacion = false;
        if (accionRealizar.equals("Mover")) {
            estadoValidacion = validacionMovimiento(casillas);
            if (estadoValidacion == true) {

            }else{
                throw new BussinessException(508);
            }
        } else {
            if (handler != null) {
                handler.faseDeAccion(objPersonajeAplica, objPersonajeAplicar, casillas, accionRealizar);
            }
        }

    }

    private boolean validacionMovimiento(String[] casillas) {
        boolean estadoValidacion = false;
        int rowActual, colActual;
        int rowMover, colMover;
        rowActual = Integer.parseInt(casillas[0].split("-")[0]);
        colActual = Integer.parseInt(casillas[0].split("-")[1]);
        rowMover = Integer.parseInt(casillas[1].split("-")[0]);
        colMover = Integer.parseInt(casillas[1].split("-")[1]);

        if (rowActual == rowMover) {
            int colIzquierda = colActual - 1;
            int colDerecha = colActual + 1;
            if (colIzquierda == colMover) {
                estadoValidacion = true;
            } else if (colDerecha == colMover) {
                estadoValidacion = true;
            } else {
                estadoValidacion = false;
            }
        } else {
            int rowArriba = rowActual + 1;
            int rowAbajo = rowActual - 1;

            if (rowArriba == rowMover) {
                estadoValidacion = true;
            } else if (rowAbajo == rowMover) {
                estadoValidacion = true;
            } else {
                estadoValidacion = false;
            }
        }
        return estadoValidacion;

    }
}
