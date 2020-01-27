package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegistrationPlateServiceTest {

    private static final String REGISTRATION_NUMBER = "WW242424";

    @Autowired
    private RegistrationPlateService registrationPlateService;

    @Test
    void recognize() throws RegistrationPlateException {
        //given:
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel(REGISTRATION_NUMBER);
        //when:
        Optional<RegistrationPlateModel> recognizedRegistrationPlateModelOptional = registrationPlateService.recognize(registrationPlateModel, null);
        RegistrationPlateModel recognizedRegistrationPlateModel = recognizedRegistrationPlateModelOptional.orElse(new RegistrationPlateModel());
        String registrationNumber = recognizedRegistrationPlateModel.getRegistrationNumber();
        //then:
        Assertions.assertEquals(REGISTRATION_NUMBER, registrationNumber,"RegistrationPlateNumbers aren't equal.");
    }
}