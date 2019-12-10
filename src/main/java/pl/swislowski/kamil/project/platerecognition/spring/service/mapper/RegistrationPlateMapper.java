package pl.swislowski.kamil.project.platerecognition.spring.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.RegistrationPlateEntity;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.Optional;

@Component
public class RegistrationPlateMapper {

    public Optional<RegistrationPlateModel> fromEntity(RegistrationPlateEntity registrationPlateEntity) {
        ModelMapper modelMapper = new ModelMapper();
        RegistrationPlateModel registrationPlateModel = modelMapper.map(registrationPlateEntity, RegistrationPlateModel.class);
        return Optional.ofNullable(registrationPlateModel);
    }

    public Optional<RegistrationPlateEntity> fromModel(RegistrationPlateModel registrationPlateModel) {
        ModelMapper modelMapper = new ModelMapper();
        RegistrationPlateEntity registrationPlateEntity = modelMapper.map(registrationPlateModel, RegistrationPlateEntity.class);
        return Optional.ofNullable(registrationPlateEntity);
    }
}
