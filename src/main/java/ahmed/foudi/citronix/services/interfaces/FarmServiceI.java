package ahmed.foudi.citronix.services.interfaces;

import ahmed.foudi.citronix.dto.farm.FarmRequestDTO;
import ahmed.foudi.citronix.dto.farm.FarmResponseDTO;

import java.util.List;

public interface FarmServiceI {

    FarmResponseDTO save(FarmRequestDTO farmRequestDTO);
    List<FarmResponseDTO> findAll();
    FarmResponseDTO findById(Long id);
    FarmResponseDTO update(Long id,FarmRequestDTO farmRequestDTO);
    FarmResponseDTO delete(Long id);

}
