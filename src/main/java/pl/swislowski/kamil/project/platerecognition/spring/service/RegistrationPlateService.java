package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.springframework.stereotype.Service;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.NoRegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.RegistrationPlateEntity;
import pl.swislowski.kamil.project.platerecognition.spring.dao.repository.RegistrationPlateRepository;
import pl.swislowski.kamil.project.platerecognition.spring.service.mapper.RegistrationPlateMapper;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.Optional;

@Service
public class RegistrationPlateService {

    private RegistrationPlateRepository registrationPlateRepository;

    private RegistrationPlateMapper registrationPlateMapper;

    public RegistrationPlateService(RegistrationPlateRepository registrationPlateRepository, RegistrationPlateMapper registrationPlateMapper) {
        this.registrationPlateRepository = registrationPlateRepository;
        this.registrationPlateMapper = registrationPlateMapper;
    }

    public Optional<RegistrationPlateModel> recognize(RegistrationPlateModel registrationPlateModel) throws RegistrationPlateException {
        Optional<RegistrationPlateEntity> optionalRegistrationPlateEntity = registrationPlateMapper.fromModel(registrationPlateModel);
        RegistrationPlateEntity registrationPlateEntity = optionalRegistrationPlateEntity.orElseThrow(() -> new NoRegistrationPlateException("No registration plate from request."));
        RegistrationPlateEntity savedRegistrationPlateEntity = registrationPlateRepository.save(registrationPlateEntity);
        return registrationPlateMapper.fromEntity(savedRegistrationPlateEntity);
    }
}
