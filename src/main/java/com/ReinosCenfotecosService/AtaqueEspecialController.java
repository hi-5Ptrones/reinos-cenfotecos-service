/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService;

import com.ReinosCenfotecosService.Core.AtaqueEspecial.GestorAtaqueEspecial;
import com.ReinosCenfotecosService.Entities.AtaqueEspcecial;
import com.ReinosCenfotecosService.exceptions.BussinessException;
import com.ReinosCenfotecosService.exceptions.ExceptionManager;
import com.ReinosCenfotecosService.webapi.models.ApiResponse;
import com.ReinosCenfotecosService.webapi.models.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jscru
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AtaqueEspecialController {
    
    
    ApiResponse apiResponse;

    @RequestMapping(value = "/api/ataqueEspecial/asignarAtaqueEspecial", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ApiResponse> asignarAtaqueEspecial(AtaqueEspcecial specialAttack, 
            int idPersonajeAplica, int idPersonajeaAplicar){
        ResponseEntity serverResponse;
        try {
            apiResponse = new ApiResponse();
            GestorAtaqueEspecial gestor = new GestorAtaqueEspecial();
            gestor.asignarAtaqueEspcial(specialAttack, idPersonajeAplica, idPersonajeaAplicar);
            apiResponse.message = "Ataque especial Exitoso";
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);
        } catch (BussinessException bex) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(bex.message.message,
                    ExceptionManager.StackTraceToString(bex)), HttpStatus.OK);

        } catch (Exception e) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.OK);
        }
    }
}
