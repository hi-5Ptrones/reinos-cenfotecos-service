/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService;

import com.ReinosCenfotecosService.Core.Partida.GestorPartidas;
import com.ReinosCenfotecosService.Entities.Partida;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;
import com.ReinosCenfotecosService.webapi.models.ApiResponse;
import com.ReinosCenfotecosService.webapi.models.ExceptionResponse;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
            if(apiResponse.data != null){
                apiResponse.message = "Partida Encontrada";
            }else{
                 throw new BussinessException(301);
            }
            
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/partida/actualizarPartida", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApiResponse> actualizarPartida(HttpEntity<String> httpEntity) {
        ResponseEntity serverResponse;
        try {
            Gson gson = new Gson();
            apiResponse = new ApiResponse();
            String json = httpEntity.getBody();
            Partida partida = gson.fromJson(json, Partida.class);
            GestorPartidas gestor = new GestorPartidas();
            apiResponse.data = gestor.actualizarPartida(partida);
            apiResponse.message = "Partida Encontrada";
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (BussinessException bex) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(bex.message.message,
                    ExceptionManager.StackTraceToString(bex)), HttpStatus.INTERNAL_SERVER_ERROR);
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
      @RequestMapping(value = "/api/partida/fachadaCrearPartidaRapida", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApiResponse> fachadaCrearPartidaRapida() {
        ResponseEntity serverResponse;
        try {
            apiResponse = new ApiResponse();
            GestorPartidas gestor = new GestorPartidas();
            apiResponse.data = gestor.crearPartidaRapida();
            apiResponse.message = "Partida Iniciada ";
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
