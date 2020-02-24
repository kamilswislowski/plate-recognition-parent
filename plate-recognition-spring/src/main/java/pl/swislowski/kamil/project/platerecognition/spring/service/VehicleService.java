package pl.swislowski.kamil.project.platerecognition.spring.service;

import org.springframework.stereotype.Service;
import pl.swislowski.kamil.project.platerecognition.spring.dao.repository.VehicleRepository;
import pl.swislowski.kamil.project.platerecognition.spring.service.mapper.VehicleMapper;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;
    private VehicleMapper vehicleMapper;

    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }
}
