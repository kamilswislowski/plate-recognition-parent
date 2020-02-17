package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.PlateRecognizerException;
import pl.swislowski.kamil.project.platerecognition.spring.service.mapper.RegistrationPlateMapper;
import pl.swislowski.kamil.project.platerecognition.spring.service.platerecognizer.model.PlateRecognizerResponse;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.net.URLDecoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;


@SpringBootTest
class APlateRecognizerServiceTest {

    private static final String PLATE_NUMBER = "SB8903R";
    private static final String FIAT_TABLICE_JPG = "fiat tablice.jpg";
    @Autowired
    private PlateRecognizerService plateRecognizerService;

    @Autowired
    private RegistrationPlateMapper registrationPlateMapper;

    @Test
    void recognize() throws PlateRecognizerException {
        //given:
        Resource resource = new ClassPathResource(URLDecoder.decode(FIAT_TABLICE_JPG));
        //when:
        PlateRecognizerResponse plateRecognizerResponse = plateRecognizerService.recognize(resource);
        RegistrationPlateModel recognizedRegistrationPlateModel = registrationPlateMapper.fromResponse(plateRecognizerResponse);
        String registrationNumber = recognizedRegistrationPlateModel.getRegistrationNumber();
        //then:
        assertThat("PlateNumbers aren't equal.", PLATE_NUMBER, equalToIgnoringCase(registrationNumber));
    }
}