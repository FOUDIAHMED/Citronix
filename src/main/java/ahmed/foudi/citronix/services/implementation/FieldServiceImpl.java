package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dto.field.FieldRequestDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.services.interfaces.FieldServiceI;

import java.util.List;

public class FieldServiceImpl implements FieldServiceI {
    @Override
    public FieldResponseDTO save(FieldRequestDTO fieldRequestDTO) {
        return null;
    }

    @Override
    public FieldResponseDTO update(Long id, FieldRequestDTO fieldRequestDTO) {
        return null;
    }

    @Override
    public FieldResponseDTO delete(Long id) {
        return null;
    }

    @Override
    public List<FieldResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public FieldResponseDTO findById(Long id) {
        return null;
    }
}
