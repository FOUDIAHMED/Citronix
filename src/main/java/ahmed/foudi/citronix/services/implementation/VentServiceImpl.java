package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dao.VentDAO;
import ahmed.foudi.citronix.dao.HarvestDAO;
import ahmed.foudi.citronix.dto.vent.VentRequestDTO;
import ahmed.foudi.citronix.dto.vent.VentResponseDTO;
import ahmed.foudi.citronix.entities.Vent;
import ahmed.foudi.citronix.entities.Harvest;
import ahmed.foudi.citronix.mappers.vent.VentDtoMapper;
import ahmed.foudi.citronix.services.interfaces.VentServiceI;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class VentServiceImpl implements VentServiceI {
    
    private final VentDAO ventDAO;
    private final HarvestDAO harvestDAO;
    private final VentDtoMapper ventDtoMapper;

    @Override
    public VentResponseDTO save(VentRequestDTO ventRequestDTO) {
        Vent vent = ventDtoMapper.toEntity(ventRequestDTO);
        
        Harvest harvest = harvestDAO.findById(ventRequestDTO.getHarvestId())
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + ventRequestDTO.getHarvestId()));
        vent.setHarvest(harvest);
        
        Vent savedVent = ventDAO.save(vent);
        return ventDtoMapper.toDto(savedVent);
    }

    @Override
    public VentResponseDTO update(Long id, VentRequestDTO ventRequestDTO) {
        Vent existingVent = ventDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vent not found with id: " + id));
        
        existingVent.setDate(ventRequestDTO.getDate());
        existingVent.setQuantity(ventRequestDTO.getQuantity());
        existingVent.setPrixUnitaire(ventRequestDTO.getPrixUnitaire());
        
        if (ventRequestDTO.getHarvestId() != null && 
            !ventRequestDTO.getHarvestId().equals(existingVent.getHarvest().getId())) {
            Harvest newHarvest = harvestDAO.findById(ventRequestDTO.getHarvestId())
                    .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + ventRequestDTO.getHarvestId()));
            existingVent.setHarvest(newHarvest);
        }
        
        Vent updatedVent = ventDAO.save(existingVent);
        return ventDtoMapper.toDto(updatedVent);
    }

    @Override
    public VentResponseDTO delete(Long id) {
        Vent vent = ventDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vent not found with id: " + id));
        VentResponseDTO response = ventDtoMapper.toDto(vent);
        ventDAO.deleteById(id);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VentResponseDTO> findAll() {
        return ventDAO.findAll().stream()
                .map(ventDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public VentResponseDTO findById(Long id) {
        Vent vent = ventDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vent not found with id: " + id));
        return ventDtoMapper.toDto(vent);
    }
}
