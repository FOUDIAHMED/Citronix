package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dto.harvest.HarvestRequestDTO;
import ahmed.foudi.citronix.dto.harvest.HarvestResponseDTO;
import ahmed.foudi.citronix.services.interfaces.HarvestServiceI;

import java.util.List;

public class HarvestServiceImpl implements HarvestServiceI {
    @Override
    public HarvestResponseDTO save(HarvestRequestDTO harvestRequestDTO) {
        return null;
    }

    @Override
    public HarvestResponseDTO update(Long id, HarvestRequestDTO harvestRequestDTO) {
        return null;
    }

    @Override
    public HarvestResponseDTO delete(Long id) {
        return null;
    }

    @Override
    public HarvestResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<HarvestResponseDTO> findAll() {
        return List.of();
    }
}
