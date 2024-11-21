package ahmed.foudi.citronix.mappers.harvestdetails;

import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsEmbeddedDTO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsRequestDTO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsResponseDTO;
import ahmed.foudi.citronix.entities.HarvestDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HarvestDetailsDtoMapper {
    HarvestDetailsResponseDTO toDto(HarvestDetails field);
    HarvestDetails toEntity(HarvestDetailsRequestDTO request);
    HarvestDetailsEmbeddedDTO toEmbeddedDto(HarvestDetails harvestDetails);
}
