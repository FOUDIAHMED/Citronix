package ahmed.foudi.citronix.dto.vent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentRequestDTO {
    private LocalDate date;
    private double prixUnitaire;
    private double quantity;
    private Long harvestId;
}
