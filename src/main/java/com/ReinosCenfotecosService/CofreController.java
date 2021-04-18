/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService;

import com.ReinosCenfotecosService.Core.Cofre.GestorCofre;
import com.ReinosCenfotecosService.Core.Dados.GestorPrototype;
import com.ReinosCenfotecosService.Core.Partida.GestorPartidas;
import com.ReinosCenfotecosService.Entities.Dado;
import com.ReinosCenfotecosService.Entities.Jugador;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;
import com.ReinosCenfotecosService.webapi.models.ApiResponse;
import com.ReinosCenfotecosService.webapi.models.ExceptionResponse;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guiss
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CofreController {
    private static GestorPrototype Prototype;
    ApiResponse apiResponse;
    
     @RequestMapping(value = "/api/partida/mostrarCofre", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ApiResponse> mostrarCofre( ArrayList<Dado> dados, Jugador jugador) {
        ResponseEntity serverResponse;
        try {
            apiResponse = new ApiResponse();
            GestorCofre gestor = new GestorCofre();
            apiResponse.data = gestor. nuevo_cofre_Dado(dados,jugador);
            apiResponse.message = "Partida Iniciada ";
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
