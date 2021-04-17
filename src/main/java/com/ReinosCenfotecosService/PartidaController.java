/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService;

import com.ReinosCenfotecosService.Core.Partida.GestorPartidas;
import com.ReinosCenfotecosService.Entities.AtaqueEspecial;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;
import com.ReinosCenfotecosService.webapi.models.ApiResponse;
import com.ReinosCenfotecosService.webapi.models.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jorge
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PartidaController {

    ApiResponse apiResponse;

    @RequestMapping(value = "/api/partida/getPartidaById", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ApiResponse> getPartidaById(int idPartida) {
        ResponseEntity serverResponse;
        try {
            apiResponse = new ApiResponse();
            GestorPartidas gestor = new GestorPartidas();
            apiResponse.data = gestor.obtenerPartidaById(idPartida);
            apiResponse.message = "Partida Encontrada";
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/partida/crearPartida", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApiResponse> crearPartida(String nombre1, String nombre2, int ganador) {
        ResponseEntity serverResponse;
        try {
            apiResponse = new ApiResponse();
            GestorPartidas gestor = new GestorPartidas();
            apiResponse.data = gestor.construcionPartida(nombre1, nombre2, ganador);
            apiResponse.message = "Partida Iniciada ";
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (BussinessException bex) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(bex.message.message,
                    ExceptionManager.StackTraceToString(bex)), HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
