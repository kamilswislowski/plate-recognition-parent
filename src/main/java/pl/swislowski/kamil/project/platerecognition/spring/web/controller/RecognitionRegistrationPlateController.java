package pl.swislowski.kamil.project.platerecognition.spring.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/plate-recognition")
public class RecognitionRegistrationPlateController {
    private static final Logger LOGGER = Logger.getLogger(RecognitionRegistrationPlateController.class.getName());

    @PostMapping(value = "/recognize")
    public RegistrationPlateModel recognize() {
        LOGGER.info("Recognizing ...");
        return new RegistrationPlateModel("WI 234212");
    }
}
