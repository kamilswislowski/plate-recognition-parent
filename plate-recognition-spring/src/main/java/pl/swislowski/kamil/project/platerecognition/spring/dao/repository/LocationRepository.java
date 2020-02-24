package pl.swislowski.kamil.project.platerecognition.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.swislowski.kamil.project.platerecognition.spring.dao.entity.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
}
