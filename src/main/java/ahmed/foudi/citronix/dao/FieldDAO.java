package ahmed.foudi.citronix.dao;

import ahmed.foudi.citronix.entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDAO extends JpaRepository<Field, Long> {
}
