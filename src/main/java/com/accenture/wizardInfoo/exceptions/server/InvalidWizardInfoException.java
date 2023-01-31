package com.accenture.wizardInfoo.exceptions.server;

public class InvalidWizardInfoException extends RuntimeException{
    public InvalidWizardInfoException(){

    }

    public InvalidWizardInfoException(String message){
        super(message);
    }
}
