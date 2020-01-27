package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.PlateRecognizerException;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@AutoConfigureMockMvc
class RecognitionRegistrationPlateServiceTest {

    private static final String REGISTRATION_NUMBER = "WK221133";
    @Autowired
    private RecognitionRegistrationPlateService recognitionRegistrationPlateService;


    @Test
    void recognize() throws RegistrationPlateException, PlateRecognizerException {
        //given:
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel(REGISTRATION_NUMBER);
        //when:
        Optional<RegistrationPlateModel> recognizedRegistrationPlateModelOptional = recognitionRegistrationPlateService.recognize(registrationPlateModel, null);
        RegistrationPlateModel recognizedRegistrationPlateModel = recognizedRegistrationPlateModelOptional.orElse(new RegistrationPlateModel());
        String registrationNumber = recognizedRegistrationPlateModel.getRegistrationNumber();
        //then:
        Assertions.assertEquals(REGISTRATION_NUMBER, registrationNumber, "RegistrationPlateNumbers aren't equal");
    }
}