package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HarvestDetails {
    @EmbeddedId
    private EmbdedId id;

    @ManyToOne
    @MapsId("treeId")
    @JoinColumn(name="tree_id")
    private Tree tree;

    @ManyToOne
    @MapsId("harvestId")
    @JoinColumn(name="harvest_id")
    private Harvest harvest;

    private double quantity;
}
