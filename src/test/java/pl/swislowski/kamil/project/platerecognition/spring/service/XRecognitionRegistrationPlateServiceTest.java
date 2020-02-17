package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.PlateRecognizerException;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.net.URLDecoder;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@AutoConfigureMockMvc
class XRecognitionRegistrationPlateServiceTest {

    private static final String REGISTRATION_NUMBER = "sb8903r";
    private static final String FIAT_TABLICE_JPG = "fiat tablice.jpg";
    @Autowired
    private RecognitionRegistrationPlateService recognitionRegistrationPlateService;


    @Test
    void recognize() throws RegistrationPlateException, PlateRecognizerException {
        //given:
        Resource resource = new ClassPathResource(URLDecoder.decode(FIAT_TABLICE_JPG));
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel(REGISTRATION_NUMBER);
        //when:
        Optional<RegistrationPlateModel> recognizedRegistrationPlateModelOptional = recognitionRegistrationPlateService.recognize(registrationPlateModel, resource);
        RegistrationPlateModel recognizedRegistrationPlateModel = recognizedRegistrationPlateModelOptional.orElse(new RegistrationPlateModel());
        String registrationNumber = recognizedRegistrationPlateModel.getRegistrationNumber();
        //then:
        Assertions.assertEquals(REGISTRATION_NUMBER, registrationNumber, "RegistrationPlateNumbers aren't equal");
    }
}