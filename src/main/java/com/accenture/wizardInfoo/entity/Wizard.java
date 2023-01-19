package com.accenture.wizardInfoo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.OffsetDateTime;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wizard")
@Data
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    Integer age;
    @Column(name = "joinedDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    OffsetDateTime joinedDate;
    String active;

    public OffsetDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(OffsetDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
