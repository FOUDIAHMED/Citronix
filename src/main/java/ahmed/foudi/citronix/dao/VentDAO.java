package ahmed.foudi.citronix.dao;

import ahmed.foudi.citronix.entities.Vent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentDAO extends JpaRepository<Vent,Long> {
}
