package ahmed.foudi.citronix.mappers.farm;

import ahmed.foudi.citronix.dto.farm.FarmEmbeddedDTO;
import ahmed.foudi.citronix.dto.farm.FarmRequestDTO;
import ahmed.foudi.citronix.dto.farm.FarmResponseDTO;
import ahmed.foudi.citronix.entities.Farm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface FarmDtoMapper {
    FarmResponseDTO toDto(Farm farm);

    Farm toEntity(FarmRequestDTO request);

    FarmEmbeddedDTO toEmbeddedDto(Farm farm);
}
