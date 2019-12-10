package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.springframework.stereotype.Service;
import pl.swislowski.kamil.project.platerecognition.spring.dao.repository.RegistrationPlateRepository;

@Service
public class RegistrationPlateService {

    private RegistrationPlateRepository registrationPlateRepository;

    public RegistrationPlateService(RegistrationPlateRepository registrationPlateRepository) {
        this.registrationPlateRepository = registrationPlateRepository;
    }
}
