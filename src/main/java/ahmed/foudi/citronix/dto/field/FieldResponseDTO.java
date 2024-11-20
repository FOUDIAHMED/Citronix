package ahmed.foudi.citronix.dto.field;

import ahmed.foudi.citronix.dto.farm.FarmEmbeddedDTO;
import ahmed.foudi.citronix.dto.tree.TreeEmbeddedDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FieldResponseDTO {
    Long id;

    double surface;

    FarmEmbeddedDTO farm;

}
