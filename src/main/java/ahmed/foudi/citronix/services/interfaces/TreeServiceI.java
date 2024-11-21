package ahmed.foudi.citronix.services.interfaces;

import ahmed.foudi.citronix.dto.tree.TreeRequestDTO;
import ahmed.foudi.citronix.dto.tree.TreeResponseDTO;

import java.util.List;

public interface TreeServiceI {
    TreeResponseDTO save(TreeRequestDTO requestDTO);
    TreeResponseDTO update(Long id,TreeRequestDTO requestDTO);
    TreeResponseDTO delete(Long id);
    TreeResponseDTO findbyId(Long id);
    List<TreeResponseDTO> findAll();
}
