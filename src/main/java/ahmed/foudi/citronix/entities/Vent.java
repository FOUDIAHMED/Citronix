package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date de vente est obligatoire")
    private LocalDate date;

    @NotNull(message = "Le prix unitaire est obligatoire")
    @Min(value = 0, message = "Le prix unitaire ne peut pas être négatif")
    private double prixUnitaire;

    @NotNull(message = "La quantité est obligatoire")
    @Min(value = 0, message = "La quantité ne peut pas être négative")
    private double quantity;

    @NotNull(message = "Le client est obligatoire")
    private String client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;

    // Calculate revenue
    public double calculateRevenue() {
        return this.quantity * this.prixUnitaire;
    }
}
