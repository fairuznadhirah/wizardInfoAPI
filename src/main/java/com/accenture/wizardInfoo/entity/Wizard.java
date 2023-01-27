package com.accenture.wizardInfoo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "wizard")
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "wizard_id", nullable = false)
    private Long wizard_id;

    @Column(name = "wizard_name", nullable = false)
    private String wizard_name;

    @Column(name = "wizard_age", nullable = false)
    private Integer wizard_age;

    @Column(name = "wizard_joined_Date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate wizard_joined_Date;

    @Column(name = "wizard_active")
    private String wizard_active;

    public Long getWizard_id() {
        return wizard_id;
    }

    public void setWizard_id(Long wizard_id) {
        this.wizard_id = wizard_id;
    }

    public String getWizard_name() {
        return wizard_name;
    }

    public void setWizard_name(String wizard_name) {
        this.wizard_name = wizard_name;
    }

    public Integer getWizard_age() {
        return wizard_age;
    }

    public void setWizard_age(Integer wizard_age) {
        this.wizard_age = wizard_age;
    }

    public LocalDate getWizard_joined_Date() {
        return wizard_joined_Date;
    }

    public void setWizard_joined_Date(LocalDate wizard_joined_Date) {
        this.wizard_joined_Date = wizard_joined_Date;
    }

    public String getWizard_active() {
        return wizard_active;
    }

    public void setWizard_active(String wizard_active) {
        this.wizard_active = wizard_active;
    }

}
