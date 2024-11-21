package ahmed.foudi.citronix.dao;

import ahmed.foudi.citronix.entities.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestDAO extends JpaRepository<Harvest, Long> {
}
