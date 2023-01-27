package com.accenture.wizardInfoo.exceptions;

import com.accenture.wizardInfoo.entity.Wizard;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WizardException  extends RuntimeException{

    public static final String INVALID_EXIST_WIZARD = "Error: Wizard with id does not exist";
    public static final String INVALID_DELETE_WIZARD = "Error: Wizard Id does not exist";

    public WizardException(String message){
        super(message);
    }
}
