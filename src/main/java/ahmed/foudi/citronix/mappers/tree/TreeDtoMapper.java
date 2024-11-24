package ahmed.foudi.citronix.mappers.tree;

import ahmed.foudi.citronix.dto.tree.TreeEmbeddedDTO;
import ahmed.foudi.citronix.dto.tree.TreeRequestDTO;
import ahmed.foudi.citronix.dto.tree.TreeResponseDTO;
import ahmed.foudi.citronix.entities.HarvestDetails;
import ahmed.foudi.citronix.entities.Tree;
import ahmed.foudi.citronix.mappers.harvestdetails.HarvestDetailsDtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = HarvestDetailsDtoMapper.class)
public interface TreeDtoMapper {
    TreeResponseDTO toDto(Tree field);
    Tree toEntity(TreeRequestDTO request);
    TreeEmbeddedDTO toEmbeddedDto(Tree field);
}
