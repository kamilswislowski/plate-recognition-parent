package pl.swislowski.kamil.project.platerecognition.spring.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.RegistrationPlateEntity;
import pl.swislowski.kamil.project.platerecognition.spring.service.platerecognizer.model.PlateRecognizerResponse;
import pl.swislowski.kamil.project.platerecognition.spring.service.platerecognizer.model.Result;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.RegistrationPlateModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class RegistrationPlateMapperTest {

    public static final long ID = 2L;
    private static final String PLATE = "sb8903r";

    @Test
    void givenEntityAndMapper_whenMapFromEntity_thenModelNotNull() {
        //given:
        RegistrationPlateEntity registrationPlateEntity = new RegistrationPlateEntity();
        RegistrationPlateMapper registrationPlateMapper = new RegistrationPlateMapper();
        //when:
        Optional<RegistrationPlateModel> optionalRegistrationPlateModel = registrationPlateMapper.fromEntity(registrationPlateEntity);
        //then:
        RegistrationPlateModel registrationPlateModel = null;
        if (optionalRegistrationPlateModel.isPresent()) {
            registrationPlateModel = optionalRegistrationPlateModel.get();
        }
        Assertions.assertNotNull(registrationPlateModel, "RegistrationPlateModel not null");

    }

    @Test
    void givenEntityAndMapper_whenMapFromEntity_thenModelValuesNotNull() {
        //given:
        RegistrationPlateEntity registrationPlateEntity = new RegistrationPlateEntity();
        registrationPlateEntity.setId(ID);
        RegistrationPlateMapper registrationPlateMapper = new RegistrationPlateMapper();
        //when:
        Optional<RegistrationPlateModel> optionalRegistrationPlateModel = registrationPlateMapper.fromEntity(registrationPlateEntity);
        //then:
        RegistrationPlateModel registrationPlateModel = null;
        if (optionalRegistrationPlateModel.isPresent()) {
            registrationPlateModel = optionalRegistrationPlateModel.get();
        }
//        Assertions.assertEquals(ID, registrationPlateModel.getId(), "Ids aren't equal.");

        RegistrationPlateModel finalRegistrationPlateModel = registrationPlateModel;
        Assertions.assertAll(
                () -> Assertions.assertEquals(ID, finalRegistrationPlateModel.getId(), "Ids aren't equal."),
                () -> Assertions.assertEquals(registrationPlateEntity.getRegistrationNumber(), finalRegistrationPlateModel.getRegistrationNumber(), "Registrations Numbers aren't equal.")
        );
    }

    @Test
    void givenModelAndMapper_whenMapFromModel_thenEntityNotNull() {
        //given:
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel();
        RegistrationPlateMapper registrationPlateMapper = new RegistrationPlateMapper();
        //when:
        Optional<RegistrationPlateEntity> optionalRegistrationPlateEntity = registrationPlateMapper.fromModel(registrationPlateModel);
        //then:
        RegistrationPlateEntity registrationPlateEntity = null;
        if (optionalRegistrationPlateEntity.isPresent()) {
            registrationPlateEntity = optionalRegistrationPlateEntity.get();
        }
        Assertions.assertNotNull(registrationPlateEntity, "RegistrationPlateEntity not null.");
    }

    @Test
    void givenModelAndMapper_whenMapFromModel_thenEntityValuesNotNull() {
        //given:
        RegistrationPlateModel registrationPlateModel = new RegistrationPlateModel();
        registrationPlateModel.setId(ID);
        RegistrationPlateMapper registrationPlateMapper = new RegistrationPlateMapper();
        //when:
        Optional<RegistrationPlateEntity> optionalRegistrationPlateEntity = registrationPlateMapper.fromModel(registrationPlateModel);
        //then:
        RegistrationPlateEntity registrationPlateEntity = null;
        if (optionalRegistrationPlateEntity.isPresent()) {
            registrationPlateEntity = optionalRegistrationPlateEntity.get();
        }
        Assertions.assertEquals(ID, registrationPlateEntity.getId(), "Ids aren't equal.");
    }

    @Test
    void given_when_then() {
        //given:
        RegistrationPlateMapper registrationPlateMapper = new RegistrationPlateMapper();
        PlateRecognizerResponse plateRecognizerResponse = new PlateRecognizerResponse();
        List<Result> results = new ArrayList<>();
        Result result = new Result();
        result.setPlate(PLATE);
        results.add(result);
        plateRecognizerResponse.setResults(results);
        //when:
        RegistrationPlateModel registrationPlateModel = registrationPlateMapper.fromResponse(plateRecognizerResponse);
        String registrationPlateModelNumber = registrationPlateModel.getRegistrationNumber();
        Result plateResultIndexZero = plateRecognizerResponse.getResults().get(0);
        String registrationPlate = plateResultIndexZero.getPlate();
        //then:
        Assertions.assertAll(
                () -> Assertions.assertNotNull(registrationPlateModel),
                () -> Assertions.assertEquals(registrationPlateModelNumber, registrationPlate, "Registrations plate numbers aren't equal.")

        );

    }
}