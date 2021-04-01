package com.ReinosCenfotecosService;

import com.ReinosCenfotecosService.Core.Personajes.GestorPersonajes;
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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DadoController {

    ApiResponse apiResponse;

    @RequestMapping(value = "/api/dado/obtenerdado", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ApiResponse> randomValue() {
        ResponseEntity serverResponse;
        try {
            apiResponse = new ApiResponse();
            //GestorPersonajes gestor = new GestorPersonajes();
            //apiResponse.message = gestor.CrearPersonaje(tPersonaje);

            int randomArray[] = {1, 2, 3};
            for (int i = 0; i < 3; i++) {
                randomArray[i] = (int) (Math.random() * (6 - 0) + 1);
            }
            apiResponse.message = "Dado lanzado";
            apiResponse.data = randomArray;
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
