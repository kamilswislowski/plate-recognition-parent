package pl.swislowski.kamil.project.platerecognition.spring.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "GPS_COORDINATES_ID")
    private GpsCoordinatesEntity gpsCoordinates;

    public LocationEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GpsCoordinatesEntity getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(GpsCoordinatesEntity gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    @Override
    public String toString() {
        return "LocationEntity{" +
                "id=" + id +
                ", gpsCoordinatesEntity=" + gpsCoordinates +
                '}';
    }
}
