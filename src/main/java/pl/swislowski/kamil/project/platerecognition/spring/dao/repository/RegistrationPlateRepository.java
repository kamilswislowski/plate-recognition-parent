package pl.swislowski.kamil.project.platerecognition.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.RegistrationPlateEntity;

@Repository
public interface RegistrationPlateRepository extends JpaRepository<RegistrationPlateEntity, Long> {
}
