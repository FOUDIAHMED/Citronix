package ahmed.foudi.citronix.dto.harvestdetails;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailsRequestDTO {
    private Long treeId;
    private Long harvestId;
    private double quantity;
}
