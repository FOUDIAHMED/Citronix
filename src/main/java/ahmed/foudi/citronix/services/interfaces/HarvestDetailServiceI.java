package ahmed.foudi.citronix.services.interfaces;

import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsRequestDTO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsResponseDTO;

import java.util.List;

public interface HarvestDetailServiceI {
    HarvestDetailsResponseDTO save(HarvestDetailsRequestDTO harvestDetailsRequestDTO);
    HarvestDetailsResponseDTO update(Long treeId,Long harvestId,HarvestDetailsRequestDTO harvestDetailsRequestDTO);
    HarvestDetailsResponseDTO delete(Long treeId,Long harvestId);
    HarvestDetailsResponseDTO findById(Long treeId,Long harvestId);
    List<HarvestDetailsResponseDTO> findAll();

}
