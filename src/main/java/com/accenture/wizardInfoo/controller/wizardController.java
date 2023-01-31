package com.accenture.wizardInfoo.controller;

import brave.Span;
import brave.Tracer;
import com.accenture.wizardInfoo.entity.Wizard;
import com.accenture.wizardInfoo.repository.WizardRepository;
import com.accenture.wizardInfoo.service.WizardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wizard")
public class wizardController {

    @Autowired
    private WizardRepository wizardRepo;

    @Autowired
    private WizardService wizardService;

//    @Autowired
//    private Tracer tracer;

    private static final Logger logger = LoggerFactory.getLogger(wizardController.class);

    public wizardController(WizardRepository wizardRepo) {
        this.wizardRepo = wizardRepo;
    }

    @GetMapping("/wizardAll")
    public List<Wizard> getWizard() {
        return wizardService.getWizardAll();
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<Wizard> getWizard_id(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(wizardService.getWizards(id));
    }

    @PostMapping("/test/add")
    public Wizard addWizard(@RequestBody Wizard wizard) {
        return wizardService.addWizard(wizard);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWizard(@PathVariable(value = "id") long id) {
        wizardService.deleteWizard(id);
    }

    @PutMapping("/update")
    public Wizard updateWizard(@RequestBody Wizard wizard) {
        return wizardService.updateWizard(wizard);
    }
}
