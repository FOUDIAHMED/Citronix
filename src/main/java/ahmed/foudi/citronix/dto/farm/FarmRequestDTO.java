package ahmed.foudi.citronix.dto.farm;

import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FarmRequestDTO {
    String name;

    String Location;

    double superficie;

    LocalDate dateCreation;

}
