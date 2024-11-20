package ahmed.foudi.citronix.dto.harvest;

import java.time.LocalDate;

import ahmed.foudi.citronix.entities.Saison;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestEmbeddedDTO {
    private Long id;
    private LocalDate dateRecolte;
    private Saison saison;
}
