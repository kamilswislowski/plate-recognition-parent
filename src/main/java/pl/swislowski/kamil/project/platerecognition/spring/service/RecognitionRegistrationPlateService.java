package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.springframework.stereotype.Service;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.Optional;

@Service
public class RecognitionRegistrationPlateService {

    private RegistrationPlateService registrationPlateService;

    public RecognitionRegistrationPlateService(RegistrationPlateService registrationPlateService) {
        this.registrationPlateService = registrationPlateService;
    }

    public Optional<RegistrationPlateModel> recognize(RegistrationPlateModel registrationPlateModel) throws RegistrationPlateException {
        return registrationPlateService.recognize(registrationPlateModel);
    }
}
