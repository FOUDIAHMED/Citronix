package ahmed.foudi.citronix.dto.harvestdetails;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetailsRequestDTO {
     Long treeId;
     Long harvestId;
     double quantity;
}
