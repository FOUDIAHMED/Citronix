package ahmed.foudi.citronix.dto.harvestdetails;

import ahmed.foudi.citronix.dto.harvest.HarvestEmbeddedDTO;
import ahmed.foudi.citronix.dto.tree.TreeEmbeddedDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailsResponseDTO {
    private TreeEmbeddedDTO tree;
    private HarvestEmbeddedDTO harvest;
    private double quantity;
}
