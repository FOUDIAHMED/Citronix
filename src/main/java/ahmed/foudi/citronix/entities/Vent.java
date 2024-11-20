package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Vent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private double prixUnitaire;

    private double quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    private Harvest harvest;


}
