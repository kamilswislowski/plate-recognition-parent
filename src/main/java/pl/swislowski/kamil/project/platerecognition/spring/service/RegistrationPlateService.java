package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.hibernate.Session;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.NoRegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.api.exception.RegistrationPlateException;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.RegistrationPlateEntity;
import pl.swislowski.kamil.project.platerecognition.spring.dao.repository.RegistrationPlateRepository;
import pl.swislowski.kamil.project.platerecognition.spring.service.mapper.RegistrationPlateMapper;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.sql.Blob;
import java.util.Optional;

@Service
public class RegistrationPlateService {

    private RegistrationPlateRepository registrationPlateRepository;

    private RegistrationPlateMapper registrationPlateMapper;

    private EntityManager entityManager;

    public RegistrationPlateService(RegistrationPlateRepository registrationPlateRepository, RegistrationPlateMapper registrationPlateMapper, EntityManager entityManager) {
        this.registrationPlateRepository = registrationPlateRepository;
        this.registrationPlateMapper = registrationPlateMapper;
        this.entityManager = entityManager;
    }

    public Optional<RegistrationPlateModel> recognize(RegistrationPlateModel registrationPlateModel, Resource resource) throws RegistrationPlateException {
        Optional<RegistrationPlateEntity> optionalRegistrationPlateEntity = registrationPlateMapper.fromModel(registrationPlateModel);
        RegistrationPlateEntity registrationPlateEntity = optionalRegistrationPlateEntity.orElseThrow(() -> new NoRegistrationPlateException("No registration plate from request."));
        try {
            Session session = (Session) entityManager.getDelegate();
            Blob blob = session.getLobHelper().createBlob(resource.getInputStream(), resource.contentLength());
            registrationPlateEntity.setContent(blob);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RegistrationPlateEntity savedRegistrationPlateEntity = registrationPlateRepository.save(registrationPlateEntity);
        return registrationPlateMapper.fromEntity(savedRegistrationPlateEntity);
    }
}
