package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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


}
