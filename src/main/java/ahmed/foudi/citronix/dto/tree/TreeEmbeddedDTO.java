package ahmed.foudi.citronix.dto.tree;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TreeEmbeddedDTO {
    Long id;
    LocalDate plantingDate;

}
