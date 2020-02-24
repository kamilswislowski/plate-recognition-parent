package pl.swislowski.kamil.project.platerecognition.spring.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GpsCoordinatesModel {

    private Long id;

    private Double altitude;
    private Double latitude;
    private Double longitude;
}
