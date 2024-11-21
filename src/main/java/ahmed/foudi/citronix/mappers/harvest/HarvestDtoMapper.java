package ahmed.foudi.citronix.mappers.harvest;

import ahmed.foudi.citronix.dto.field.FieldEmbeddedDTO;
import ahmed.foudi.citronix.dto.field.FieldRequestDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.dto.harvest.HarvestEmbeddedDTO;
import ahmed.foudi.citronix.dto.harvest.HarvestRequestDTO;
import ahmed.foudi.citronix.dto.harvest.HarvestResponseDTO;
import ahmed.foudi.citronix.entities.Field;
import ahmed.foudi.citronix.entities.Harvest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HarvestDtoMapper {
    HarvestResponseDTO toDto(Harvest harvest);
    Harvest toEntity(HarvestRequestDTO request);
    HarvestEmbeddedDTO toEmbeddedDto(Harvest harvest);
}
