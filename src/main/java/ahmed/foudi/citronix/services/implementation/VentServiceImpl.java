package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dto.vent.VentRequestDTO;
import ahmed.foudi.citronix.dto.vent.VentResponseDTO;
import ahmed.foudi.citronix.services.interfaces.VentServiceI;

import java.util.List;

public class VentServiceImpl implements VentServiceI {
    @Override
    public VentResponseDTO save(VentRequestDTO ventRequestDTO) {
        return null;
    }

    @Override
    public VentResponseDTO update(Long id, VentRequestDTO ventRequestDTO) {
        return null;
    }

    @Override
    public VentResponseDTO delete(Long id) {
        return null;
    }

    @Override
    public List<VentResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public VentResponseDTO findById(Long id) {
        return null;
    }
}
