package ahmed.foudi.citronix.mappers.field;


import ahmed.foudi.citronix.dto.field.FieldEmbeddedDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.entities.Field;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface FieldDtoMapper {
    FieldResponseDTO toDto(Field farm);
    Field toEntity(FieldResponseDTO fieldResponseDTO);
    FieldEmbeddedDTO toEmbeddedDto(Field field);
}
