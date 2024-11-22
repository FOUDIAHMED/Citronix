package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dao.FieldDAO;
import ahmed.foudi.citronix.dao.FarmDAO;
import ahmed.foudi.citronix.dto.field.FieldRequestDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.entities.Field;
import ahmed.foudi.citronix.entities.Farm;
import ahmed.foudi.citronix.exception.farmexception.FarmException;
import ahmed.foudi.citronix.exception.fieldexception.SuperficieFieldException;
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
        Field field= validateField(fieldRequestDTO);
        Field savedField = fieldDAO.save(field);
        return fieldDtoMapper.toDto(savedField);
    }

    private Field validateField(FieldRequestDTO fieldRequestDTO){
        if(fieldRequestDTO.getSurface()<1000){
            throw new SuperficieFieldException("la superficie d'un champ doit etre au minimum de 1000 m²");
        }
        Field field = fieldDtoMapper.toEntity(fieldRequestDTO);

        Farm farm = farmDAO.findById(fieldRequestDTO.getFarmId())
                .orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + fieldRequestDTO.getFarmId()));
        if(fieldRequestDTO.getSurface()>farm.getSuperficie()/2){
            throw new SuperficieFieldException("Aucun champ ne peut dépasser 50% de la superficie totale de la ferme");
        }
        if(farm.getFields().size()>=10){
            throw new FarmException("Une ferme ne peut contenir plus de 10 champs");
        }
        double totalFieldSurface = farm.getFields().stream()
                .mapToDouble(Field::getSurface)
                .sum();
        if(totalFieldSurface+field.getSurface()>farm.getSuperficie()){
            throw new FarmException("la surface que vous avez ajouter est plus grand que la surface qui rest");
        }

        field.setFarm(farm);
        return field;
    }

    @Override
    public List<FieldResponseDTO> findAll() {
        return fieldDAO.findAll().stream()
                .map(fieldDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
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
