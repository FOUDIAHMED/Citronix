package ahmed.foudi.citronix.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , name = "surface")
    private Double surface;

    @ManyToOne(fetch = FetchType.EAGER)
    private Farm farm;

    @OneToMany(mappedBy = "field" , fetch = FetchType.EAGER)
    private List<Tree> trees;
}
