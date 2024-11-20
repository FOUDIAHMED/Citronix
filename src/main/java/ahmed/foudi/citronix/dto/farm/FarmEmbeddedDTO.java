package ahmed.foudi.citronix.dto.farm;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FarmEmbeddedDTO {
    Long id;

    String name;

    String Location;

    double superficie;

    LocalDate dateCreation;
}
