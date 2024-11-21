package ahmed.foudi.citronix.services.interfaces;

import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsRequestDTO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsResponseDTO;

import java.util.List;

public interface HarvestDetailServiceI {
    HarvestDetailsResponseDTO save(HarvestDetailsRequestDTO harvestDetailsRequestDTO);
    HarvestDetailsResponseDTO update(Long id,HarvestDetailsRequestDTO harvestDetailsRequestDTO);
    HarvestDetailsResponseDTO delete(Long id);
    HarvestDetailsResponseDTO findById(Long id);
    List<HarvestDetailsResponseDTO> findAll();

}
