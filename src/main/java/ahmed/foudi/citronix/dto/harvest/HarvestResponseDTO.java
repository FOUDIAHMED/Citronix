package ahmed.foudi.citronix.dto.harvest;

import ahmed.foudi.citronix.dto.field.FieldEmbeddedDTO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsEmbeddedDTO;
import ahmed.foudi.citronix.entities.Saison;
import ahmed.foudi.citronix.dto.vent.VentEmbeddedDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<HarvestDetailsEmbeddedDTO> harvestDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<VentEmbeddedDTO> ventes;
    private FieldEmbeddedDTO field;
}
