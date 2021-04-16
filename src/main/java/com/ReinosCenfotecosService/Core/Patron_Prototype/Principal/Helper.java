package com.ReinosCenfotecosService.Core.Patron_Prototype.Principal;

public class Helper {

    /**
     * **********************************************************
     * Metodo:	ramdomize
     *
     * Descripción:	Esta funcion permite generar un número aleatorio entre 8 y
     * 4.
     *
     * Parametros:	N/A
     *
     * @return:	Random // Número aleatorio
     * ***********************************************************
     */
    static int ramdomize() {
        return (int) (Math.random() * 8) + 1;
    }

    static int ramdomizeDNI() {
        return (int) Math.floor(Math.random() * (1000000 - 10000000) + 10000000);
    }

    static int ramdomizeCantMovimientos() {
        return (int) (Math.random() * (6 - 0) + 1);
    }

    static String ramdomizeAtaquesEspeciales() {
        String valor = "";
        int random = (int) (Math.random() * (6 - 0) + 1);
        switch (random) {
            case 1:
                valor = "volar";
                break;
            case 2:
                valor = "correr";
                break;
            case 3:
                valor = "fuerza";
                break;
            case 4:
                valor = "disparar";
                break;
            case 5:
                valor = "curar";
                break;
            case 6:
                valor = "nadar";
                break;
            case 7:
                valor = "Domingo";
                break;
            default:
                valor = "";
                break;
        }

        return valor;
    }

}
