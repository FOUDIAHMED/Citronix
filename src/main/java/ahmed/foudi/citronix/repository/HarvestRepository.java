package ahmed.foudi.citronix.repository;

import ahmed.foudi.citronix.entities.Harvest;
import ahmed.foudi.citronix.entities.Saison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {
    @Query("SELECT COUNT(h) > 0 FROM Harvest h WHERE h.field.id = :fieldId " +
            "AND h.saison = :saison AND YEAR(h.dateRecolte) = :year")
    boolean existsByFieldAndSaisonAndYear(
            @Param("fieldId") Long fieldId,
            @Param("saison") Saison saison,
            @Param("year") Integer year
    );
}
