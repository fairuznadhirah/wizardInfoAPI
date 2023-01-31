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
    WizardRepository wizardRepository;

    public Wizard addWizard(Wizard wizard){
        return wizardRepository.save(wizard);
    }

    public Wizard getWizards(Long id){
        return wizardRepository.findById(id).orElseThrow(
                () -> new WizardException(WizardException.INVALID_EXIST_WIZARD)
        );
//        return wizardRepository.findAll();
    }

    public List<Wizard> getWizardAll(){
        return wizardRepository.findAll();
    }

    public void deleteWizard(long id){
        wizardRepository.findById(id).orElseThrow(
                () -> new WizardException(WizardException.INVALID_EXIST_WIZARD)
        );
        wizardRepository.deleteById(id);
    }

    public Wizard updateWizard(Wizard wizard){
        wizardRepository.findById(wizard.getWizard_id()).orElseThrow(
                () -> new WizardException("Wizard with id= " + wizard.getWizard_id() + " does not exist")
                );
        return wizardRepository.save(wizard);
    }

}
