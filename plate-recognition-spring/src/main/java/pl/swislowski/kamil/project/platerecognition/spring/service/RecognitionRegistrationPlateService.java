package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.PlateRecognizerException;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.service.mapper.RegistrationPlateMapper;
import pl.swislowski.kamil.project.platerecognition.spring.service.platerecognizer.model.PlateRecognizerResponse;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.Optional;

@Service
public class RecognitionRegistrationPlateService {

    private RegistrationPlateService registrationPlateService;
    private PlateRecognizerService plateRecognizerService;
    private RegistrationPlateMapper registrationPlateMapper;

    public RecognitionRegistrationPlateService(RegistrationPlateService registrationPlateService, PlateRecognizerService plateRecognizerService, RegistrationPlateMapper registrationPlateMapper) {
        this.registrationPlateService = registrationPlateService;
        this.plateRecognizerService = plateRecognizerService;
        this.registrationPlateMapper = registrationPlateMapper;
    }

    public Optional<RegistrationPlateModel> recognize(
            RegistrationPlateModel recognitionRegistrationPlateRequest,
            Resource resource) throws RegistrationPlateException, PlateRecognizerException {

        PlateRecognizerResponse plateRecognizerResponse = plateRecognizerService.recognize(resource);
        RegistrationPlateModel registrationPlateModel = registrationPlateMapper.fromResponse(plateRecognizerResponse);
        return registrationPlateService.recognize(registrationPlateModel, resource);
    }
}
