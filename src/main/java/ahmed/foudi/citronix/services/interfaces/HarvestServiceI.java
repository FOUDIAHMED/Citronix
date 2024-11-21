package ahmed.foudi.citronix.services.interfaces;

import ahmed.foudi.citronix.dto.harvest.HarvestRequestDTO;
import ahmed.foudi.citronix.dto.harvest.HarvestResponseDTO;

import java.util.List;

public interface HarvestServiceI {
    HarvestResponseDTO save(HarvestRequestDTO harvestRequestDTO);
    HarvestResponseDTO update(Long id,HarvestRequestDTO harvestRequestDTO);
    HarvestResponseDTO delete(Long id);
    HarvestResponseDTO findById(Long id);
    List<HarvestResponseDTO> findAll();
}
