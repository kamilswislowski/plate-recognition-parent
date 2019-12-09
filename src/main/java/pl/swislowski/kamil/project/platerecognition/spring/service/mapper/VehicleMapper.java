package pl.swislowski.kamil.project.platerecognition.spring.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.VehicleEntity;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.VehicleModel;

import java.util.Optional;

@Component
public class VehicleMapper {

    public Optional<VehicleModel> fromEntity(VehicleEntity vehicleEntity) {
        ModelMapper modelMapper = new ModelMapper();
        VehicleModel vehicleModel = modelMapper.map(vehicleEntity, VehicleModel.class);
        return Optional.ofNullable(vehicleModel);
    }

    public Optional<VehicleEntity> fromModel(VehicleModel vehicleModel) {
        ModelMapper modelMapper = new ModelMapper();
        VehicleEntity vehicleEntity = modelMapper.map(vehicleModel, VehicleEntity.class);
        return Optional.ofNullable(vehicleEntity);
    }
}
