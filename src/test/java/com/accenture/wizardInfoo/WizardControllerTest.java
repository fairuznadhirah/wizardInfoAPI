package com.accenture.wizardInfoo;

import com.accenture.wizardInfoo.entity.Wizard;
import com.accenture.wizardInfoo.repository.WizardRepository;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WizardControllerTest {

    @Autowired
    private WizardRepository wizardRepository;

    private static final Logger log = LoggerFactory.getLogger(WizardControllerTest.class);

    @Test
    public void testCreate(){
        Wizard wizard = new Wizard();
        wizard.setWizard_id(2L);
        wizard.setWizard_name("Fairuz");
        wizard.setWizard_age(24);
        wizard.setWizard_joined_Date(LocalDate.parse("2022-09-04"));
        wizard.setWizard_active("yes");
        wizardRepository.save(wizard);

        System.out.println();
        assertNotNull(wizardRepository.findById(2L).get());
    }

    @Test
    public void testGetWizard(){
        List<Wizard> list = wizardRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void testGetIDWizard(){
        try{
            Wizard wizard = wizardRepository.findById(2L).get();
        }catch (Exception e) {
            assertEquals(24, e.getMessage());
        }
    }

    @Test
    public void testUpdateWizard(){
        Wizard wizard = wizardRepository.findById(15L).get();
        wizard.setWizard_name("Farra");
        wizardRepository.save(wizard);
        assertNotEquals("Syaqeerah", wizardRepository.findById(15L).get().getWizard_name());

    }

    @Test
    public void testDeleteWizard(){
        wizardRepository.deleteById(16L);
        assertThat(wizardRepository.existsById(3L)).isFalse();

    }


















//   @Test
//   @Rollback(value = false)
//   public void deleteWizardTest(){
//       Wizard wizard = wizardRepository.findById(1L).get();
//       wizardRepository.delete(wizard);
//
//       Wizard wizard1 = null;
//       Optional<Wizard> optionalWizard = wizardRepository.findById(1L);
//
//       if(optionalWizard.isPresent()){
//           wizard1 = optionalWizard.get();
//       }
//       Assertions.assertThat(wizard1).isNull();
//   }

//    @Test
//    @Order(1)
//    @Rollback(value = false)
//    public void saveWizardTest(){
//        Wizard wizard = Wizard.builder()
//                .wizard_id(4L)
//                .wizard_name("rose")
//                .wizard_age(54)
//                .wizard_joined_Date(LocalDate.ofEpochDay(2013-02-04))
//                .wizard_active("yes")
//                .build();
//
//        wizardRepository.save(wizard);
//
//        Assertions.assertThat(wizard.getWizard_id()).isGreaterThan(0);
//
//    }
//
//    @Test
//    @Order(2)
//    public void getWizardTest(){
//        Wizard wizard = wizardRepository.findById(1L).get();
//
//        Assertions.assertThat(wizard.getWizard_id()).isEqualTo(1L);
//    }
//
//    @Test
//    @Order(3)
//    public void getListWizardTest(){
//        List<Wizard> wizardList = wizardRepository.findAll();
//
//        Assertions.assertThat(wizardList.size()).isGreaterThan(0);
//    }

//    @Test
//    @Order(4)
//    @Rollback(value = false)
//    public void updateWizardTest(){
//
//        Wizard wizard = wizardRepository.findById(1L).get();
//
//        wizard.setName("naddd");
//
//        Wizard wizardUpdate = wizardRepository.save(wizard);
//
//        Assertions.assertThat(wizardUpdate.getName()).isEqualTo("Nadhirah");
//
//    }

//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteWizardTest(){
//        Wizard wizard = wizardRepository.findById(1L).get();
//
//        wizardRepository.delete(wizard);
//
//        Wizard wizard1 = null;
//
//        Optional<Wizard> optionalWizard = wizardRepository.findByName("naddd");
//
//        if (optionalWizard.isPresent()){
//            wizard1 = optionalWizard.get();
//        }
//
//        Assertions.assertThat(wizard1).isNull();
//    }



























//    private Wizard wizard;

//    @Test
//    public void deleteWizardTest(){
//        wizardRepository.save(wizard);
//
//        wizardRepository.deleteById(wizard.getId());
//        Optional<Wizard> wizardOptional = wizardRepository.findById(wizard.getId());
//
//        assertThat(wizardOptional).isEmpty();
//
//    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void deleteOrderTest(){
        Wizard wizard = wizardRepository.findById(1L).get();

        wizardRepository.delete(wizard);

        Wizard wizard1 = null;

        Optional<Wizard> optionalWizard = wizardRepository.findById(1L);
        if (optionalWizard.isPresent()) {
            wizard1 = optionalWizard.get();
        }

        Assertions.assertThat(wizard1).isNull();
    }
}
