package ahmed.foudi.citronix.repository;

import ahmed.foudi.citronix.entities.Vent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentRepository extends JpaRepository<Vent,Long> {
}
