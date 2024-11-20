package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateRecolte;

    private double totalquantity;

    private Saison saison;

    @OneToMany(mappedBy = "Harvest" , fetch = FetchType.EAGER)
    private List<HarvestDetails> harvestDetails;

}
