package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dao.FieldDAO;
import ahmed.foudi.citronix.dao.FarmDAO;
import ahmed.foudi.citronix.dto.field.FieldRequestDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.entities.Field;
import ahmed.foudi.citronix.entities.Farm;
import ahmed.foudi.citronix.mappers.field.FieldDtoMapper;
import ahmed.foudi.citronix.services.interfaces.FieldServiceI;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FieldServiceImpl implements FieldServiceI {
    
    private final FieldDAO fieldDAO;
    private final FarmDAO farmDAO;
    private final FieldDtoMapper fieldDtoMapper;

    @Override
    public FieldResponseDTO save(FieldRequestDTO fieldRequestDTO) {
        Field field = fieldDtoMapper.toEntity(fieldRequestDTO);
        
        // Set the farm reference
        Farm farm = farmDAO.findById(fieldRequestDTO.getFarmId())
                .orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + fieldRequestDTO.getFarmId()));
        field.setFarm(farm);
        
        Field savedField = fieldDAO.save(field);
        return fieldDtoMapper.toDto(savedField);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FieldResponseDTO> findAll() {
        return fieldDAO.findAll().stream()
                .map(fieldDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FieldResponseDTO findById(Long id) {
        Field field = fieldDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + id));
        return fieldDtoMapper.toDto(field);
    }

    @Override
    public FieldResponseDTO update(Long id, FieldRequestDTO fieldRequestDTO) {
        Field existingField = fieldDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + id));

        existingField.setSurface(fieldRequestDTO.getSurface());

        if (fieldRequestDTO.getFarmId() != null && 
            !fieldRequestDTO.getFarmId().equals(existingField.getFarm().getId())) {
            Farm newFarm = farmDAO.findById(fieldRequestDTO.getFarmId())
                    .orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + fieldRequestDTO.getFarmId()));
            existingField.setFarm(newFarm);
        }
        
        Field updatedField = fieldDAO.save(existingField);
        return fieldDtoMapper.toDto(updatedField);
    }

    @Override
    public FieldResponseDTO delete(Long id) {
        Field field = fieldDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + id));
        FieldResponseDTO response = fieldDtoMapper.toDto(field);
        fieldDAO.deleteById(id);
        return response;
    }
}
