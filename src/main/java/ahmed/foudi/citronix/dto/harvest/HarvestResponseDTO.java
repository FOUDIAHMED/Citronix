package ahmed.foudi.citronix.dto.harvest;

import ahmed.foudi.citronix.entities.Saison;
import ahmed.foudi.citronix.dto.vent.VentEmbeddedDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestResponseDTO {
    private Long id;
    private LocalDate dateRecolte;
    private double totalquantity;
    private Saison saison;
    private List<HarvestDetailsEmbeddedDTO> harvestDetails;
    private List<VentEmbeddedDTO> ventes;
}
