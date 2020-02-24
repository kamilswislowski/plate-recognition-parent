package pl.swislowski.kamil.project.platerecognition.spring.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.RegistrationPlateEntity;
import pl.swislowski.kamil.project.platerecognition.spring.service.platerecognizer.model.PlateRecognizerResponse;
import pl.swislowski.kamil.project.platerecognition.spring.service.platerecognizer.model.Result;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RecognitionRegistrationPlateRequest;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.List;
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

    public RegistrationPlateModel fromRequest(RecognitionRegistrationPlateRequest recognitionRegistrationPlateRequest) {
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel();
        registrationPlateModel.setFileName(recognitionRegistrationPlateRequest.getFileName());

        Long fileSize = recognitionRegistrationPlateRequest.getFileSize();
//        registrationPlateModel.setContent(IOUtils.readFully(recognitionRegistrationPlateRequest.getInputStream(), (int)fileSize));
        return null;
    }

    public RegistrationPlateModel fromResponse(PlateRecognizerResponse plateRecognizerResponse) {
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel();
        if (plateRecognizerResponse != null) {
            String filename = plateRecognizerResponse.getFilename();
            registrationPlateModel.setFileName(filename);
            List<Result> results = plateRecognizerResponse.getResults();
            if (results != null && results.size() > 0) {
                Result result = results.get(0);
                if (result != null) {
                    String plate = result.getPlate();
                    registrationPlateModel.setRegistrationNumber(plate);
                }
            }
        }
        return registrationPlateModel;
    }
}
