package ahmed.foudi.citronix.dto.vent;

import ahmed.foudi.citronix.dto.harvest.HarvestEmbeddedDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentResponseDTO {
    private Long id;
    private LocalDate date;
    private double prixUnitaire;
    private double quantity;
    private String client;
    private double revenue;
    private HarvestEmbeddedDTO harvest;
}
