package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la ferme est obligatoire")
    @Size(min = 3, max = 50, message = "Le nom doit être entre 3 et 50 caractères")
    private String name;

    @NotBlank(message = "La localisation est obligatoire")
    private String location;

    @NotNull(message = "La superficie est obligatoire")
    @Min(value = 20000, message = "La superficie minimale d'une ferme doit être de 2 hectares (20 000 m²)")
    private Double superficie;

    @Column(name = "date_creation")
    @NotNull(message = "La date de création est obligatoire")
    private LocalDate dateCreation;

    @OneToMany(mappedBy = "farm", fetch = FetchType.EAGER)
    private List<Field> fields;
}
