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
    private Long id;
    private String name;

    private String location;

    private double superficie;

    private LocalDate dateCreation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FieldResponseDTO> fields;
}
