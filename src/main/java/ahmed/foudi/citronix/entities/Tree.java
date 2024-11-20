package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate plantingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "field_id",nullable = false)
    private Field field;

    @OneToMany(mappedBy = "Tree" , fetch = FetchType.EAGER)
    private List<HarvestDetails> harvestDetails;


}
