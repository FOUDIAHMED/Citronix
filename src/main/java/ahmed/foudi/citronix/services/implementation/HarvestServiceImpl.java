package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dao.HarvestDAO;
import ahmed.foudi.citronix.dto.harvest.HarvestRequestDTO;
import ahmed.foudi.citronix.dto.harvest.HarvestResponseDTO;
import ahmed.foudi.citronix.entities.Harvest;
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
    
    private final HarvestDAO harvestDAO;
    private final HarvestDtoMapper harvestDtoMapper;

    @Override
    public HarvestResponseDTO save(HarvestRequestDTO harvestRequestDTO) {
        Harvest harvest = harvestDtoMapper.toEntity(harvestRequestDTO);
        Harvest savedHarvest = harvestDAO.save(harvest);
        return harvestDtoMapper.toDto(savedHarvest);
    }

    @Override
    public HarvestResponseDTO update(Long id, HarvestRequestDTO harvestRequestDTO) {
        Harvest existingHarvest = harvestDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + id));
        
        existingHarvest.setDateRecolte(harvestRequestDTO.getDateRecolte());
        existingHarvest.setTotalquantity(harvestRequestDTO.getTotalquantity());
        existingHarvest.setSaison(harvestRequestDTO.getSaison());
        
        Harvest updatedHarvest = harvestDAO.save(existingHarvest);
        return harvestDtoMapper.toDto(updatedHarvest);
    }

    @Override
    public HarvestResponseDTO delete(Long id) {
        Harvest harvest = harvestDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + id));
        HarvestResponseDTO response = harvestDtoMapper.toDto(harvest);
        harvestDAO.deleteById(id);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public HarvestResponseDTO findById(Long id) {
        Harvest harvest = harvestDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + id));
        return harvestDtoMapper.toDto(harvest);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HarvestResponseDTO> findAll() {
        return harvestDAO.findAll().stream()
                .map(harvestDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
