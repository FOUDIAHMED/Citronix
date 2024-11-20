package ahmed.foudi.citronix.dto.harvest;

import java.time.LocalDate;

import ahmed.foudi.citronix.entities.Saison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestEmbeddedDTO {
    private Long id;
    private LocalDate dateRecolte;
    private Saison saison;
}
