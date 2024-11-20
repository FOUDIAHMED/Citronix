package ahmed.foudi.citronix.dto.farm;

import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FarmResponseDTO {
    Long id;
    String name;

    String Location;

    double superficie;

    LocalDate dateCreation;

    List<FieldResponseDTO> fields;
}
