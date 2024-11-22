package ahmed.foudi.citronix.services.interfaces;

import ahmed.foudi.citronix.dto.field.FieldRequestDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.exception.farmexception.FarmException;
import ahmed.foudi.citronix.exception.fieldexception.SuperficieFieldException;

import java.util.List;

public interface FieldServiceI {
    FieldResponseDTO save(FieldRequestDTO fieldRequestDTO);
    FieldResponseDTO update(Long id,FieldRequestDTO fieldRequestDTO);
    FieldResponseDTO delete(Long id);
    List<FieldResponseDTO> findAll();
    FieldResponseDTO findById(Long id);

}
