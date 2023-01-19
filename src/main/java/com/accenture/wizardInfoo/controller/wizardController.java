package com.accenture.wizardInfoo.controller;

//import brave.Tracer;
import com.accenture.wizardInfoo.entity.Wizard;
import com.accenture.wizardInfoo.repository.WizardRepository;
import com.accenture.wizardInfoo.service.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class wizardController {

    private final WizardRepository wizardRepo;

//    Tracer tracer;

    @Autowired
    WizardService wizardService;

    public wizardController(WizardRepository wizardRepo) {
        this.wizardRepo = wizardRepo;
//        this.tracer=tracer;
    }

    @GetMapping("/test")
    public List<Wizard> getUser() {
        return wizardService.getWizards();
    }

    @PostMapping("/test/add")
    public Wizard createUser(@RequestBody Wizard wizard){
        return wizardService.addWizard(wizard);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable(value = "id") long id){
        wizardService.deleteWizard(id);
    }

    @PutMapping("/update")
    public Wizard updateUser(@RequestBody Wizard wizard) {
        return wizardService.updateWizard(wizard);
    }
}
