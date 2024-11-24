package ahmed.foudi.citronix.mappers.vent;

import ahmed.foudi.citronix.dto.vent.VentEmbeddedDTO;
import ahmed.foudi.citronix.dto.vent.VentRequestDTO;
import ahmed.foudi.citronix.dto.vent.VentResponseDTO;
import ahmed.foudi.citronix.entities.Vent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VentDtoMapper {
    @Mapping(target = "revenue", expression = "java(vent.calculateRevenue())")
    VentResponseDTO toDto(Vent vent);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "harvest", ignore = true)
    Vent toEntity(VentRequestDTO request);
    
    VentEmbeddedDTO toEmbeddedDto(Vent vent);
}
