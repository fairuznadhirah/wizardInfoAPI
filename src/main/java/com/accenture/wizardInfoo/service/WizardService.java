package com.accenture.wizardInfoo.service;

import com.accenture.wizardInfoo.entity.Wizard;
import com.accenture.wizardInfoo.exceptions.WizardException;
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
//        repository.findById(wizard.getId()).orElseThrow(
//                () -> new WizardException(WizardException.INVALID_EXIST_WIZARD)
//        );
        return repository.findAll();
    }

    public void deleteWizard(long id){
        repository.findById(id).orElseThrow(
                () -> new WizardException(WizardException.INVALID_EXIST_WIZARD)
        );
        repository.deleteById(id);
    }

    public Wizard updateWizard(Wizard wizard){
        repository.findById(wizard.getWizard_id()).orElseThrow(
                () -> new WizardException("Wizard with id= " + wizard.getWizard_id() + " does not exist")
                );
        return repository.save(wizard);
    }

}
