package pl.swislowski.kamil.project.platerecognition.spring.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLES")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "REGISTRATION_PLATE_ID")
    private RegistrationPlateEntity registrationPlate;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "LOCATION_ID")
    private LocationEntity location;

    public VehicleEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegistrationPlateEntity getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(RegistrationPlateEntity registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "id=" + id +
                ", registrationPlate=" + registrationPlate +
                ", location=" + location +
                '}';
    }
}
