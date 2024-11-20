package ahmed.foudi.citronix.dto.harvestdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailsEmbeddedDTO {
    private Long treeId;
    private Long harvestId;
    private double quantity;
}
