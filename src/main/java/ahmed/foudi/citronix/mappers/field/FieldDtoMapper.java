package ahmed.foudi.citronix.mappers.field;


import ahmed.foudi.citronix.dto.field.FieldEmbeddedDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.entities.Field;
import ahmed.foudi.citronix.mappers.farm.FarmDtoMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {FarmDtoMapper.class})
public interface FieldDtoMapper {
    FieldResponseDTO toDto(Field field);
    Field toEntity(FieldResponseDTO fieldResponseDTO);

    FieldEmbeddedDTO toEmbeddedDto(Field field);
}
