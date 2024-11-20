package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String Localisation;

    private double superficie;

    private LocalDate dateCreation;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "farm")
    private List<Field> fields;



}
