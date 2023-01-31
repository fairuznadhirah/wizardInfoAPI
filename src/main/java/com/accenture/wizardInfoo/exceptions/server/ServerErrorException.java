package com.accenture.wizardInfoo.exceptions.server;

public class ServerErrorException extends RuntimeException{

    public ServerErrorException(){
    }

    public ServerErrorException(String message){
        super(message);
    }
}
