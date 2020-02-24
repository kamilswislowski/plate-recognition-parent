package pl.swislowski.kamil.project.platerecognition.spring.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationModel {

    private Long id;

    private GpsCoordinatesModel gpsCoordinates;
}
