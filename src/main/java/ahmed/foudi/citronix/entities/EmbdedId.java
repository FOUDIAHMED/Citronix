package ahmed.foudi.citronix.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class EmbdedId {

    @Column(name = "tree_id")
    Long treeId;

    @Column(name = "harvest_id")
    Long harvestId;


}
