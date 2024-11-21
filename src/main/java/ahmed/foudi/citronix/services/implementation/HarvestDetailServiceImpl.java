package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsRequestDTO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsResponseDTO;
import ahmed.foudi.citronix.services.interfaces.HarvestDetailServiceI;

import java.util.List;

public class HarvestDetailServiceImpl implements HarvestDetailServiceI {
    @Override
    public HarvestDetailsResponseDTO save(HarvestDetailsRequestDTO harvestDetailsRequestDTO) {
        return null;
    }

    @Override
    public HarvestDetailsResponseDTO update(Long id, HarvestDetailsRequestDTO harvestDetailsRequestDTO) {
        return null;
    }

    @Override
    public HarvestDetailsResponseDTO delete(Long id) {
        return null;
    }

    @Override
    public HarvestDetailsResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<HarvestDetailsResponseDTO> findAll() {
        return List.of();
    }
}
