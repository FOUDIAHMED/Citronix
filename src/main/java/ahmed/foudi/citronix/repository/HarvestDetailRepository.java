package ahmed.foudi.citronix.repository;

import ahmed.foudi.citronix.entities.EmbdedId;
import ahmed.foudi.citronix.entities.HarvestDetails;
import ahmed.foudi.citronix.entities.Saison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestDetailRepository extends JpaRepository<HarvestDetails, EmbdedId> {
    @Query("SELECT COUNT(hd) > 0 FROM HarvestDetails hd " +
           "WHERE hd.tree.id = :treeId " +
           "AND hd.harvest.saison = :saison")
    boolean existsByTreeAndSaison(
        @Param("treeId") Long treeId,
        @Param("saison") Saison saison
    );
}
