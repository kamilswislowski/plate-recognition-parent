package pl.swislowski.kamil.project.platerecognition.spring.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationPlateModel {
    private Long id;

    private LocationModel location;

    private String registrationNumber;

    public RegistrationPlateModel(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}