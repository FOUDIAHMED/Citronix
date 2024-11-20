package ahmed.foudi.citronix.dto.harvest;

import ahmed.foudi.citronix.entities.Saison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestRequestDTO {
    private LocalDate dateRecolte;
    private double totalquantity;
    private Saison saison;
}
