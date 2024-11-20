package ahmed.foudi.citronix.dto.farm;

import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmRequestDTO {
    String name;

    String Location;

    double superficie;

    LocalDate dateCreation;

}
