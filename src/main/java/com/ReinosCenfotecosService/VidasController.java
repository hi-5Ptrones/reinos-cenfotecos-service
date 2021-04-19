package com.ReinosCenfotecosService;

import com.ReinosCenfotecosService.Core.Observador.Gestor_Observador;
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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class VidasController {

    private static Gestor_Observador observador = new Gestor_Observador();
    private static int vida = 0;
    ApiResponse apiResponse;

    @RequestMapping(value = "/api/vidas/iniciarVidas", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ApiResponse> randomValue() {
        ResponseEntity serverResponse;
        try {
            vida = 4;
            apiResponse = new ApiResponse();
            apiResponse.message = "La vida del jugador es: "+vida;
            apiResponse.data = vida;

            //Observador
            observador.NuevoProducto("Vidas");
            observador.NuevoObservador("Vidas restantes", "Vidas");
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {
            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/vidas/bajarVidas", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ApiResponse> cambiarTurno() {
        ResponseEntity serverResponse;
        try {
            //llamar las vidas del jugador
            vida = 0;
            apiResponse = new ApiResponse();
            apiResponse.message = "La vida del jugador es:"+ vida;
            apiResponse.data = vida;

            //Observador
            observador.NuevoValor("Vidas", vida);
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {
            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
