/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ReinosCenfotecosService.exceptions;

import com.ReinosCenfotecosService.Entities.ApplicationMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author jscru
 */
public class ExceptionManager {

    public static final String PATH = "C:\\Users\\jscru\\Documents\\GitHub\\reinos-cenfotecos-service";
    private static ExceptionManager instance;
    public static HashMap<String, ApplicationMessage> listMessages = new HashMap<String, ApplicationMessage>();

    private ExceptionManager() throws Exception {
        loadMessages();
    }

    public static ExceptionManager GetInstance() throws Exception {
        if (instance == null) {
            instance = new ExceptionManager();
        }

        return instance;
    }

    public void Process(Exception ex) throws BussinessException, Exception {

        BussinessException bex = new BussinessException();

        if (ex instanceof BussinessException) {
            bex = (BussinessException) ex;
            ProcessBussinesException(bex);
        } else {
            ProcessGenericException(ex);
        }
    }

    private void loadMessages() throws Exception {
        String data;

        try {
            FileReader reader = new FileReader(PATH + "\\config\\ConfigExceptions.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;

            while ((datos = buffer.readLine()) != null) {
                ApplicationMessage mensaje = new ApplicationMessage();
                String[] parts = datos.split(":");
                mensaje.id = Integer.parseInt(parts[0]);
                mensaje.message = parts[1];
                listMessages.put(parts[0], mensaje);
            }
            reader.close();
        } catch (IOException e) {
            ProcessGenericException(e);
        }
    }

    private void ProcessGenericException(Exception ex) throws Exception{
         String pattern = "yyyy_MM_dd__hh_mm_ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String today = simpleDateFormat.format(new Date());
        String logName = "\\Logs\\"
                + today + 
                "_" + "log.txt";
        String logPath = PATH + logName;
        
        String exceptionMessage = ex.getMessage() + "\n" + ex.getStackTrace();
        File logFile = new File(logPath);
        try {
            logFile.createNewFile();
            FileWriter myWriter = new FileWriter(logPath);
            myWriter.write(exceptionMessage);
            myWriter.close();
        } catch (IOException e) {
            ProcessGenericException(e);
            
        }
        throw ex;
    }
    private void ProcessBussinesException(BussinessException bex) throws BussinessException, Exception {
        String pattern = "yyyy_MM_dd__hh_mm_ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String today = simpleDateFormat.format(new Date());
        String logName = "\\Logs\\"
                + today + 
                "_" + "log.txt";
        String logPath = PATH + logName;
        bex.message = getMessage(bex);
        String exceptionMessage = bex.message.message + "\n" + bex.getStackTrace();
        File logFile = new File(logPath);
        try {
            logFile.createNewFile();
            FileWriter myWriter = new FileWriter(logPath);
            myWriter.write(exceptionMessage);
            myWriter.close();
        } catch (IOException e) {
            ProcessGenericException(e);
            
        }
        throw bex;
    }

    private ApplicationMessage getMessage(BussinessException bex) {
        ApplicationMessage appMessage = new ApplicationMessage();
        appMessage.message = "Mesage not found";

        String key = String.valueOf(bex.exceptionId);

        if (listMessages.containsKey(key)) {
            appMessage = listMessages.get(key);
        }
        return appMessage;
    }

}
