package ahmed.foudi.citronix.repository;

import ahmed.foudi.citronix.entities.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {
}
