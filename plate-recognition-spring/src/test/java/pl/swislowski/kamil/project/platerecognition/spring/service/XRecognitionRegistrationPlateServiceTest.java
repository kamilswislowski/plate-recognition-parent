package pl.swislowski.kamil.project.platerecognition.spring.service;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.PlateRecognizerException;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.net.URLDecoder;
import java.util.Optional;

@SpringBootTest
class XRecognitionRegistrationPlateServiceTest {

    private static final String PLATE_NUMBER = "sb8903r";
    private static final String FIAT_TABLICE_JPG = "fiat_tablice.jpg";

    @Autowired
    private RecognitionRegistrationPlateService recognitionRegistrationPlateService;

    @Test
    @Disabled
    void recognize() throws RegistrationPlateException, PlateRecognizerException {
        //given:
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel(PLATE_NUMBER);
        Resource resource = new ClassPathResource(URLDecoder.decode(FIAT_TABLICE_JPG));
        //when:
        Optional<RegistrationPlateModel> recognizedRegistrationPlateModelOptional = recognitionRegistrationPlateService.recognize(registrationPlateModel, resource);
        RegistrationPlateModel recognizedRegistrationPlateModel = recognizedRegistrationPlateModelOptional.orElse(new RegistrationPlateModel());
        String registrationNumber = recognizedRegistrationPlateModel.getRegistrationNumber();
        //then:
        Assertions.assertEquals(PLATE_NUMBER, registrationNumber, "RegistrationPlateNumbers aren't equal");
    }
}