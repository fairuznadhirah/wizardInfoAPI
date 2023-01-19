package com.accenture.wizardInfoo.repository;

import com.accenture.wizardInfoo.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WizardRepository extends JpaRepository<Wizard, Long> {
}
