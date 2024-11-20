package ahmed.foudi.citronix.mappers.farm;

import ahmed.foudi.citronix.dto.farm.FarmEmbeddedDTO;
import ahmed.foudi.citronix.dto.farm.FarmRequestDTO;
import ahmed.foudi.citronix.dto.farm.FarmResponseDTO;
import ahmed.foudi.citronix.entities.Farm;
import ahmed.foudi.citronix.mappers.field.FieldDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={FieldDtoMapper.class})
public interface FarmDtoMapper {
     FarmResponseDTO toDto(Farm farm);
     Farm toEntity(FarmRequestDTO farmResponseDTO);
     FarmEmbeddedDTO toEmbeddedDto(Farm farm);
}
