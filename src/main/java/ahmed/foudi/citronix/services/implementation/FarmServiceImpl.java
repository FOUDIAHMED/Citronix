package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dao.FarmDAO;
import ahmed.foudi.citronix.dto.farm.FarmRequestDTO;
import ahmed.foudi.citronix.dto.farm.FarmResponseDTO;
import ahmed.foudi.citronix.entities.Farm;
import ahmed.foudi.citronix.mappers.farm.FarmDtoMapper;
import ahmed.foudi.citronix.services.interfaces.FarmServiceI;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmServiceI {
    
    private final FarmDAO farmDAO;
    private final FarmDtoMapper farmDtoMapper;

    @Override
    public FarmResponseDTO save(FarmRequestDTO farmRequestDTO) {
        Farm farm = farmDtoMapper.toEntity(farmRequestDTO);
        Farm savedFarm = farmDAO.save(farm);
        return farmDtoMapper.toDto(savedFarm);
    }

    @Override
    public List<FarmResponseDTO> findAll() {
        return farmDAO.findAll().stream()
                .map(farmDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FarmResponseDTO findById(Long id) {
        Farm farm = farmDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + id));
        return farmDtoMapper.toDto(farm);
    }

    @Override
    public FarmResponseDTO update(Long id, FarmRequestDTO farmRequestDTO) {
        Farm existingFarm = farmDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + id));
   
        existingFarm.setName(farmRequestDTO.getName());
        existingFarm.setLocation(farmRequestDTO.getLocation());
        existingFarm.setSuperficie(farmRequestDTO.getSuperficie());
        existingFarm.setDateCreation(farmRequestDTO.getDateCreation());
        
        Farm updatedFarm = farmDAO.save(existingFarm);
        return farmDtoMapper.toDto(updatedFarm);
    }

    @Override
    public FarmResponseDTO delete(Long id) {
        Farm farm = farmDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + id));
        FarmResponseDTO response = farmDtoMapper.toDto(farm);
        farmDAO.deleteById(id);
        return response;
    }
}
