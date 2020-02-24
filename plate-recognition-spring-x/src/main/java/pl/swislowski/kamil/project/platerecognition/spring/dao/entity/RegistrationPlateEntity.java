package pl.swislowski.kamil.project.platerecognition.spring.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "REGISTRATION_PLATES")
public class RegistrationPlateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "LOCATION_ID")
    private LocationEntity location;

    private String registrationNumber;

    private String fileName;
    @Lob
    private Blob content;

    public RegistrationPlateEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    //    public byte[] getContent() {
//        return content;
//    }
//
//    public void setContent(byte[] content) {
//        this.content = content;
//    }

    @Override
    public String toString() {
        return "RegistrationPlateEntity{" +
                "id=" + id +
                ", location=" + location +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
