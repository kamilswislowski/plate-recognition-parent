package pl.swislowski.kamil.project.platerecognition.spring.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

@RestController
@RequestMapping(value = "/plate-recognition")
public class RecognitionRegistrationPlateController {

    @PostMapping(value = "/recognize")
    public RegistrationPlateModel recognize() {
        return new RegistrationPlateModel("WI 234212");
    }
}
