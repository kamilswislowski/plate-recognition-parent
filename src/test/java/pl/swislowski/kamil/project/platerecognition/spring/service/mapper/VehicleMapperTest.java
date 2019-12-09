package pl.swislowski.kamil.project.platerecognition.spring.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.VehicleEntity;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.VehicleModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VehicleMapperTest {

    public static final long ID = 1L;

    @Test
    void givenEntityAndMapper_whenMapFromEntity_thenModelNotNull() {
        //given:
        VehicleEntity vehicleEntity = new VehicleEntity();
        VehicleMapper vehicleMapper = new VehicleMapper();
        //when:
        Optional<VehicleModel> optionalVehicleModel = vehicleMapper.fromEntity(vehicleEntity);
        //then:
        VehicleModel vehicleModel = null;
        if (optionalVehicleModel.isPresent()) {
            vehicleModel = optionalVehicleModel.get();
        }
        Assertions.assertNotNull(vehicleModel, "VehicleModel not null.");
    }

    @Test
    void givenEntityAndMapper_whenMapFromEntityWithValues_thenModelValuesNotNull1() {
        //given:
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setId(ID);
        VehicleMapper vehicleMapper = new VehicleMapper();
        //when:
        Optional<VehicleModel> optionalVehicleModel = vehicleMapper.fromEntity(vehicleEntity);
        //then:
        VehicleModel vehicleModel = null;
        if (optionalVehicleModel.isPresent()) {
            vehicleModel = optionalVehicleModel.get();
        }
        Assertions.assertEquals(ID, vehicleModel.getId(), "Ids aren't equal.");
    }

    @Test
    void fromModel() {
        //TODO: Dokończyć analogicznie jak powyżej.
    }
}