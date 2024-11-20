package ahmed.foudi.citronix.dto.farm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmEmbeddedDTO {
    Long id;
    String name;

    String Location;

    double superficie;

    LocalDate dateCreation;
}
