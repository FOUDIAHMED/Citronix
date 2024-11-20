package ahmed.foudi.citronix.mappers.field;


import ahmed.foudi.citronix.dto.field.FieldEmbeddedDTO;
import ahmed.foudi.citronix.dto.field.FieldRequestDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.entities.Field;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FieldDtoMapper {

    FieldResponseDTO toDto(Field field);
    Field toEntity(FieldRequestDTO request);
    FieldEmbeddedDTO toEmbeddedDto(Field field);
}
