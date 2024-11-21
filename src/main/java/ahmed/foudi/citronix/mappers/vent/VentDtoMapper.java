package ahmed.foudi.citronix.mappers.vent;

import ahmed.foudi.citronix.dto.vent.VentEmbeddedDTO;
import ahmed.foudi.citronix.dto.vent.VentRequestDTO;
import ahmed.foudi.citronix.dto.vent.VentResponseDTO;
import ahmed.foudi.citronix.entities.Vent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentDtoMapper {
    VentResponseDTO toDto(Vent field);
    Vent toEntity(VentRequestDTO request);
    VentEmbeddedDTO toEmbeddedDto(Vent field);
}
