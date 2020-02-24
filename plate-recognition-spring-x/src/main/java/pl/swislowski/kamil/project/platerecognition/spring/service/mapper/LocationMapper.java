package pl.swislowski.kamil.project.platerecognition.spring.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.LocationEntity;
import pl.swislowski.kamil.project.platerecognition.spring.web.model.LocationModel;

import java.util.Optional;

@Component
public class LocationMapper {

    public Optional<LocationModel> fromEntity(LocationEntity locationEntity) {
        ModelMapper modelMapper = new ModelMapper();
        LocationModel locationModel = modelMapper.map(locationEntity, LocationModel.class);
        return Optional.ofNullable(locationModel);
    }

    public Optional<LocationEntity> fromModel(LocationModel locationModel) {
        ModelMapper modelMapper = new ModelMapper();
        LocationEntity locationEntity = modelMapper.map(locationModel, LocationEntity.class);
        return Optional.ofNullable(locationEntity);

    }
}
