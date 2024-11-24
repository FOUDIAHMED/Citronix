package ahmed.foudi.citronix.dto.tree;

import ahmed.foudi.citronix.dto.field.FieldEmbeddedDTO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsEmbeddedDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeResponseDTO {
    private Long id;
    private LocalDate plantingDate;
    private FieldEmbeddedDTO field;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<HarvestDetailsEmbeddedDTO> harvestDetails;
}
