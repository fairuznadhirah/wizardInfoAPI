package com.accenture.wizardInfoo.repository;

import com.accenture.wizardInfoo.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WizardRepository extends JpaRepository<Wizard, Long> {

//    Optional<Wizard> findByName(String name);

}
