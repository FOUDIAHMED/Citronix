package ahmed.foudi.citronix.dto.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeRequestDTO {
    private LocalDate plantingDate;
    private Long fieldId;
}
