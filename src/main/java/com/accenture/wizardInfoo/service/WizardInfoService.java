package com.accenture.wizardInfoo.service;

import com.accenture.wizardInfoo.entity.Wizard;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.util.List;

public interface WizardInfoService {

    List<Wizard> getAllWizard() throws HttpRequestMethodNotSupportedException;


}
