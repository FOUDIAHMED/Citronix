package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.repository.VentRepository;
import ahmed.foudi.citronix.repository.HarvestRepository;
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
    
    private final VentRepository ventRepository;
    private final HarvestRepository harvestRepository;
    private final VentDtoMapper ventDtoMapper;

    @Override
    public VentResponseDTO save(VentRequestDTO ventRequestDTO) {
        Vent vent = ventDtoMapper.toEntity(ventRequestDTO);
        
        Harvest harvest = harvestRepository.findById(ventRequestDTO.getHarvestId())
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + ventRequestDTO.getHarvestId()));
        vent.setHarvest(harvest);
        
        Vent savedVent = ventRepository.save(vent);
        return ventDtoMapper.toDto(savedVent);
    }

    @Override
    public VentResponseDTO update(Long id, VentRequestDTO ventRequestDTO) {
        Vent existingVent = ventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vent not found with id: " + id));
        
        existingVent.setDate(ventRequestDTO.getDate());
        existingVent.setQuantity(ventRequestDTO.getQuantity());
        existingVent.setPrixUnitaire(ventRequestDTO.getPrixUnitaire());
        
        if (ventRequestDTO.getHarvestId() != null && 
            !ventRequestDTO.getHarvestId().equals(existingVent.getHarvest().getId())) {
            Harvest newHarvest = harvestRepository.findById(ventRequestDTO.getHarvestId())
                    .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + ventRequestDTO.getHarvestId()));
            existingVent.setHarvest(newHarvest);
        }
        
        Vent updatedVent = ventRepository.save(existingVent);
        return ventDtoMapper.toDto(updatedVent);
    }

    @Override
    public VentResponseDTO delete(Long id) {
        Vent vent = ventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vent not found with id: " + id));
        VentResponseDTO response = ventDtoMapper.toDto(vent);
        ventRepository.deleteById(id);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VentResponseDTO> findAll() {
        return ventRepository.findAll().stream()
                .map(ventDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public VentResponseDTO findById(Long id) {
        Vent vent = ventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vent not found with id: " + id));
        return ventDtoMapper.toDto(vent);
    }
}
