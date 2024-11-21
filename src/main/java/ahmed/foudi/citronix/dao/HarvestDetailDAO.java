package ahmed.foudi.citronix.dao;

import ahmed.foudi.citronix.entities.EmbdedId;
import ahmed.foudi.citronix.entities.HarvestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestDetailDAO extends JpaRepository<HarvestDetails, EmbdedId> {
}
