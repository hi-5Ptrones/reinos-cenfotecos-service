package com.ReinosCenfotecosService;

import com.ReinosCenfotecosService.Core.Patron_Prototype.Principal.GestorPrototype;
import com.ReinosCenfotecosService.Entities.Dado;
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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DadoController {

    private static GestorPrototype gGestorPrototype;
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
            for (int i = 0; i < randomArray.length; i++) {
                randomArray[i] = (int) (Math.random() * (6 - 0) + 1);
            }
            apiResponse.message = "Dado lanzado";
            //crea los dados en el front
            apiResponse.data = randomArray;
            //crea los dados en el backend
            creacionDados(randomArray);
            return serverResponse = new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {

            return serverResponse = new ResponseEntity(new ExceptionResponse(e.getMessage(),
                    ExceptionManager.StackTraceToString(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void creacionDados(int generados[]) {
        //crea el gestor prototype
        gGestorPrototype = new GestorPrototype(1);
        //arreglo de dados por crear en backend
        ArrayList<String> dados = new ArrayList<String>();

        //Crea dado dependiendo de lo que haya salido en el numero
        for (int i = 0; i < generados.length; i++) {
            String dado = "";
            //dados de invocación
            if (i < (generados.length - 1)) {
                if (generados[i] == 1 || generados[i] == 4) {
                    dado = ("Infanteria");
                } else if (generados[i] == 2 || generados[i] == 5) {
                    dado = ("Tanque");
                } else if (generados[i] == 3 || generados[i] == 6) {
                    dado = ("Artilleria");
                }
            } //dados de acción
            else {
                if (generados[i] == 1 || generados[i] == 4) {
                    dado = ("AtaqueEspecial");
                } else if (generados[i] == 2 || generados[i] == 5) {
                    dado = ("AtaqueNormal");
                } else if (generados[i] == 3 || generados[i] == 6) {
                    dado = ("Movimiento");
                }
            }
            dados.add(dado);
            System.out.println(dado);
        }

        //patron prototype
        for (int i = 0; i < dados.size(); i++) {
            //envia el id, DNI, y numero de militantes
            System.out.println(gGestorPrototype.nuevos_dados(dados.get(i), i));
        }
        //los imprime
        System.out.println("\n" + gGestorPrototype.obtenerDatos());
    }
}
