package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HarvestDetails {
    @EmbeddedId
    private EmbdedId id;

    @NotNull(message = "La quantité est obligatoire")
    @Min(value = 0, message = "La quantité ne peut pas être négative")
    private Double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("treeId")
    @JoinColumn(name = "tree_id")
    private Tree tree;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("harvestId")
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;
}
