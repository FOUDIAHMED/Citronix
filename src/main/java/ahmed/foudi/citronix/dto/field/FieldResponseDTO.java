package ahmed.foudi.citronix.dto.field;

import ahmed.foudi.citronix.dto.farm.FarmEmbeddedDTO;
import ahmed.foudi.citronix.dto.tree.TreeEmbeddedDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FieldResponseDTO {
    private Long id;

    private double surface;

    private FarmEmbeddedDTO farm;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TreeEmbeddedDTO> trees;

}
