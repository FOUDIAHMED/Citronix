package ahmed.foudi.citronix.dto.farm;

import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmResponseDTO {
    Long id;
    String name;

    String location;

    double superficie;

    LocalDate dateCreation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<FieldResponseDTO> fields;
}
