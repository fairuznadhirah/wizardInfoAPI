package com.accenture.wizardInfoo.controller;

import com.accenture.wizardInfoo.entity.Wizard;
import com.accenture.wizardInfoo.repository.WizardRepository;
import com.accenture.wizardInfoo.service.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wizard")
public class wizardController {

    @Autowired
    private final WizardRepository wizardRepo;

    @Autowired
    WizardService wizardService;

    public wizardController(WizardRepository wizardRepo) {
        this.wizardRepo = wizardRepo;
    }

    @GetMapping("/test")
    public List<Wizard> getWizard_id(){
        return wizardService.getWizards();
    }

//    @GetMapping("/test")
//    public List<Wizard> getWizard_id() {
//        return wizardService.getWizards();
//    }

    @PostMapping("/test/add")
    public Wizard addWizard(@RequestBody Wizard wizard){
        return wizardService.addWizard(wizard);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWizard(@PathVariable(value = "id") long id){
        wizardService.deleteWizard(id);
    }

    @PutMapping("/update")
    public Wizard updateWizard(@RequestBody Wizard wizard) {
        return wizardService.updateWizard(wizard);
    }
}
