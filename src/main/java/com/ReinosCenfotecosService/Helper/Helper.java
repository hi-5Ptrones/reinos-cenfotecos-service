/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.Helper;

import java.util.Random;

/**
 *
 * @author jscru
 */
public class Helper {

    public static int creadorDeIdentificacion() {
        Random random = new Random();
        int rnd = random.nextInt(9999 - 1000) + 1000;
        return rnd;
    }

    public static int ingetMovsMaximos(int codPersonaje) {
        Random random = new Random();
        int rnd = 0;

        switch (codPersonaje) {
            case 1:
                rnd = random.nextInt(4 - 1) + 1;
                break;
            case 2:
                rnd = random.nextInt(6 - 1) + 1;
                break;
            case 3:
                rnd = random.nextInt(2 - 1) + 1;
                break;
        }

        return rnd;
    }
}
