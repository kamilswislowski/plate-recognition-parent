package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Optional;

@SpringBootTest
class RegistrationPlateServiceTest {

    private static final String REGISTRATION_NUMBER = "sb8903r";
    private static final String FIAT_TABLICE_JPG = "fiat tablice.jpg";

    @Autowired
    private RegistrationPlateService registrationPlateService;

    @Test
    void recognize() throws RegistrationPlateException, IOException {
        //given:
        ClassPathResource resource = new ClassPathResource(URLDecoder.decode(FIAT_TABLICE_JPG));
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel(REGISTRATION_NUMBER);
        registrationPlateModel.setFileName(FIAT_TABLICE_JPG);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(resource.getInputStream(), outputStream);
        registrationPlateModel.setContent(outputStream.toByteArray());
//        try {
//            InputStream inputStream = resource.getInputStream();
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//            byte[] buffor = new byte[512];
//            while (inputStream.read(buffor) != -1) {
//                byteArrayOutputStream.write(buffor);
//            }
//
//            byte[] content = byteArrayOutputStream.toByteArray();
//            registrationPlateModel.setContent(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //when:
        Optional<RegistrationPlateModel> recognizedRegistrationPlateModelOptional = registrationPlateService.recognize(registrationPlateModel, resource);
        RegistrationPlateModel recognizedRegistrationPlateModel = recognizedRegistrationPlateModelOptional.orElse(new RegistrationPlateModel());
        String registrationNumber = recognizedRegistrationPlateModel.getRegistrationNumber();
        //then:
        Assertions.assertEquals(REGISTRATION_NUMBER, registrationNumber, "RegistrationPlateNumbers aren't equal.");
    }
}