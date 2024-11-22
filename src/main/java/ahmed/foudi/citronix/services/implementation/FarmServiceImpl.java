package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.repository.FarmRepository;
import ahmed.foudi.citronix.dto.farm.FarmRequestDTO;
import ahmed.foudi.citronix.dto.farm.FarmResponseDTO;
import ahmed.foudi.citronix.entities.Farm;
import ahmed.foudi.citronix.mappers.farm.FarmDtoMapper;
import ahmed.foudi.citronix.services.interfaces.FarmServiceI;
import ahmed.foudi.citronix.services.spesification.FarmSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmServiceI {
    
    private final FarmRepository farmRepository;
    private final FarmDtoMapper farmDtoMapper;

    @Override
    public FarmResponseDTO save(FarmRequestDTO farmRequestDTO) {
        Farm farm = farmDtoMapper.toEntity(farmRequestDTO);
        Farm savedFarm = farmRepository.save(farm);
        return farmDtoMapper.toDto(savedFarm);
    }

    @Override
    public List<FarmResponseDTO> findAll() {
        return farmRepository.findAll().stream()
                .map(farmDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FarmResponseDTO findById(Long id) {
        Farm farm = farmRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + id));
        return farmDtoMapper.toDto(farm);
    }

    @Override
    public FarmResponseDTO update(Long id, FarmRequestDTO farmRequestDTO) {
        Farm existingFarm = farmRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + id));
   
        existingFarm.setName(farmRequestDTO.getName());
        existingFarm.setLocation(farmRequestDTO.getLocation());
        existingFarm.setSuperficie(farmRequestDTO.getSuperficie());
        existingFarm.setDateCreation(farmRequestDTO.getDateCreation());
        
        Farm updatedFarm = farmRepository.save(existingFarm);
        return farmDtoMapper.toDto(updatedFarm);
    }

    @Override
    public FarmResponseDTO delete(Long id) {
        Farm farm = farmRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Farm not found with id: " + id));
        FarmResponseDTO response = farmDtoMapper.toDto(farm);
        farmRepository.deleteById(id);
        return response;
    }
    @Override
    public List<FarmResponseDTO> searchFarms(String name, Double superficie, LocalDate dateCreation) {
        Specification<Farm> spec = FarmSpecification.searchFarms(name, superficie, dateCreation);
        return farmRepository.findAll(spec).stream()
                .map(farmDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
