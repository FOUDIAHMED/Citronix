package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La superficie est obligatoire")
    @Min(value = 1000, message = "La superficie minimale d'un champ doit être de 1000 m²")
    private Double surface;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    @OneToMany(mappedBy = "field", fetch = FetchType.EAGER)
    private List<Harvest> harvests;


    @OneToMany(mappedBy = "field", fetch = FetchType.EAGER)
    private List<Tree> trees;
}
