package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.exception.harvestexception.HarvestException;
import ahmed.foudi.citronix.repository.HarvestRepository;
import ahmed.foudi.citronix.repository.FieldRepository;
import ahmed.foudi.citronix.dto.harvest.HarvestRequestDTO;
import ahmed.foudi.citronix.dto.harvest.HarvestResponseDTO;
import ahmed.foudi.citronix.entities.Harvest;
import ahmed.foudi.citronix.entities.Field;
import ahmed.foudi.citronix.entities.Saison;
import ahmed.foudi.citronix.mappers.harvest.HarvestDtoMapper;
import ahmed.foudi.citronix.services.interfaces.HarvestServiceI;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HarvestServiceImpl implements HarvestServiceI {
    
    private final HarvestRepository harvestRepository;
    private final FieldRepository fieldRepository;
    private final HarvestDtoMapper harvestDtoMapper;

    private void validateSeasonalHarvest(Field field, Saison saison, int year) {
        boolean existingHarvest = harvestRepository.existsByFieldAndSaisonAndYear(
            field.getId(), 
            saison, 
            year
        );
        
        if (existingHarvest) {
            throw new HarvestException(
                String.format("Le champ %d a déjà une récolte pour la saison %s de l'année %d", 
                    field.getId(), 
                    saison, 
                    year
                )
            );
        }
    }

    @Override
    public HarvestResponseDTO save(HarvestRequestDTO requestDTO) {
        Field field = fieldRepository.findById(requestDTO.getFieldId())
            .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + requestDTO.getFieldId()));
            
        validateSeasonalHarvest(field, requestDTO.getSaison(), requestDTO.getDateRecolte().getYear());

        Harvest harvest = harvestDtoMapper.toEntity(requestDTO);
        harvest.setField(field);
        
        Harvest savedHarvest = harvestRepository.save(harvest);
        return harvestDtoMapper.toDto(savedHarvest);
    }

    @Override
    public HarvestResponseDTO update(Long id, HarvestRequestDTO harvestRequestDTO) {
        Harvest existingHarvest = harvestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + id));
        
        existingHarvest.setDateRecolte(harvestRequestDTO.getDateRecolte());
        existingHarvest.setSaison(harvestRequestDTO.getSaison());
        
        Harvest updatedHarvest = harvestRepository.save(existingHarvest);
        return harvestDtoMapper.toDto(updatedHarvest);
    }

    @Override
    public HarvestResponseDTO delete(Long id) {
        Harvest harvest = harvestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + id));
        HarvestResponseDTO response = harvestDtoMapper.toDto(harvest);
        harvestRepository.deleteById(id);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public HarvestResponseDTO findById(Long id) {
        Harvest harvest = harvestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + id));
        return harvestDtoMapper.toDto(harvest);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HarvestResponseDTO> findAll() {
        return harvestRepository.findAll().stream()
                .map(harvestDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
