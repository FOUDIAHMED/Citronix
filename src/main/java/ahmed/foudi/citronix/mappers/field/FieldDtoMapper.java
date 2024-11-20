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
    @Mapping(target = "id", source = "id")
    @Mapping(target = "surface", source = "surface")
    @Mapping(target = "farm", source = "farm")
    FieldResponseDTO toDto(Field field);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "farm", ignore = true)
    @Mapping(target = "trees", ignore = true)
    Field toEntity(FieldRequestDTO request);
    
    @Mapping(target = "id", source = "id")
    @Mapping(target = "surface", source = "surface")
    FieldEmbeddedDTO toEmbeddedDto(Field field);
}
