package pl.swislowski.kamil.project.platerecognition.spring.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateNoContentException;
import pl.swislowski.kamil.project.platerecognition.spring.service.RecognitionRegistrationPlateService;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/plate-recognition")
public class RecognitionRegistrationPlateController {
    private static final Logger LOGGER = Logger.getLogger(RecognitionRegistrationPlateController.class.getName());

    private RecognitionRegistrationPlateService recognitionRegistrationPlateService;

    public RecognitionRegistrationPlateController(RecognitionRegistrationPlateService recognitionRegistrationPlateService) {
        this.recognitionRegistrationPlateService = recognitionRegistrationPlateService;
    }

    @PostMapping(value = "/recognize")
    public Optional<RegistrationPlateModel> recognize(@RequestParam("upload") MultipartFile upload) throws RegistrationPlateException {
        LOGGER.info("Recognizing ...");
        LOGGER.info("File name : " + upload.getOriginalFilename());
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel();
        registrationPlateModel.setFileName(upload.getOriginalFilename());
        try {
            registrationPlateModel.setContent(upload.getBytes());
        } catch (IOException e) {
            throw new RegistrationPlateNoContentException("No content, file in request.", e);
        }
        return recognitionRegistrationPlateService.recognize(registrationPlateModel);
    }
}
