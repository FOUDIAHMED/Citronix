package ahmed.foudi.citronix.dao;

import ahmed.foudi.citronix.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmDAO extends JpaRepository<Farm, Long> {
}
