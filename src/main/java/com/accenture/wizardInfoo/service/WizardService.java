package com.accenture.wizardInfoo.service;

import com.accenture.wizardInfoo.entity.Wizard;
import com.accenture.wizardInfoo.repository.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WizardService {

    @Autowired
    WizardRepository repository;

    public Wizard addWizard(Wizard wizard){
        return repository.save(wizard);
    }

    public List<Wizard> getWizards(){
        return repository.findAll();
    }

    public void deleteWizard(long id){
        repository.deleteById(id);
    }

    public Wizard updateWizard(Wizard wizard){
        return repository.save(wizard);
    }

}
