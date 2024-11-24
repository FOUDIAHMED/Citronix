package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date de récolte est obligatoire")
    @Column(name = "date_recolte")
    private LocalDate dateRecolte;


    @NotNull(message = "La quantité totale est obligatoire")
    @Min(value = 0, message = "La quantité totale ne peut pas être négative")
    private Double totalquantity;

    @NotNull(message = "La saison est obligatoire")
    private Saison saison;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "field_id")
    private Field field;

    @OneToMany(mappedBy = "harvest", fetch = FetchType.EAGER)
    private List<HarvestDetails> harvestDetails;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "harvest")
    private List<Vent> ventes;

}
