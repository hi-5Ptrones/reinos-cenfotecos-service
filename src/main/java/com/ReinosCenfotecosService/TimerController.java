package com.ReinosCenfotecosService;

import com.ReinosCenfotecosService.Core.Dados.GestorPrototype;
import com.ReinosCenfotecosService.Core.Timer.Gestor_Observador;
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
public class TimerController {

    private static Gestor_Observador observador = new Gestor_Observador();
    private static int time = 0;
    ApiResponse apiResponse;

    @RequestMapping(value = "/api/timer/iniciarTimer", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ApiResponse> randomValue() {
        ResponseEntity serverResponse;
        //iniciaTurno(time);
        try {
            time = 10;
            apiResponse = new ApiResponse();
            apiResponse.message = "Inicia el turno";
            apiResponse.data = time;

            //Observador
            observador.NuevoProducto("Tiempo");
            observador.NuevoObservador("Cuenta Regresiva", "Tiempo");
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {
            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void iniciaTurno(int pTiempo) {
        Gestor_Observador gestorOb = new Gestor_Observador();
        do {

            //Observador
            gestorOb.NuevoProducto("Tiempo");
            gestorOb.NuevoObservador("Cuenta Regresiva", "Tiempo");

            try {
                //VELOCIDAD DE LA ABEJA
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pTiempo--;

            //Observador
            gestorOb.NuevoTiempo("Tiempo", pTiempo);
        } while (pTiempo != 0);

    }


    @RequestMapping(value = "/api/timer/cambiarTurno", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ApiResponse> cambiarTurno() {
        ResponseEntity serverResponse;
        //iniciaTurno(time);
        try {
            time = 0;
            apiResponse = new ApiResponse();
            apiResponse.message = "Cambió el turno";
            apiResponse.data = time;

            //Observador
                observador.NuevoTiempo("Tiempo", time);
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {
            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
