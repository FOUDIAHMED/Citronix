package ahmed.foudi.citronix.services.interfaces;

import ahmed.foudi.citronix.dto.field.FieldRequestDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.dto.vent.VentRequestDTO;
import ahmed.foudi.citronix.dto.vent.VentResponseDTO;

import java.util.List;

public interface VentServiceI {
    VentResponseDTO save(VentRequestDTO ventRequestDTO);
    VentResponseDTO update(Long id,VentRequestDTO ventRequestDTO);
    VentResponseDTO delete(Long id);
    List<VentResponseDTO> findAll();
    VentResponseDTO findById(Long id);
}
