package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date de plantation est obligatoire")
    @Column(name = "planting_date")
    private LocalDate plantingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;

    @OneToMany(mappedBy = "tree", fetch = FetchType.EAGER)
    private List<HarvestDetails> harvestDetails;

    public int calculateAge() {
        return Period.between(this.plantingDate, LocalDate.now()).getYears();
    }

    public boolean isProductive() {
        return calculateAge()<20;
    }
}
