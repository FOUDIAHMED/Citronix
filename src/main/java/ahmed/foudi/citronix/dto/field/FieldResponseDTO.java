package ahmed.foudi.citronix.dto.field;

import ahmed.foudi.citronix.dto.farm.FarmEmbeddedDTO;
import ahmed.foudi.citronix.dto.tree.TreeEmbeddedDTO;
import lombok.Data;

import java.util.List;

@Data
public class FieldResponseDTO {
    Long id;

    double surface;

    FarmEmbeddedDTO farm;

}
