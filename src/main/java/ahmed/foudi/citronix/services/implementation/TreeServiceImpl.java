package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dto.tree.TreeRequestDTO;
import ahmed.foudi.citronix.dto.tree.TreeResponseDTO;
import ahmed.foudi.citronix.services.interfaces.TreeServiceI;

import java.util.List;

public class TreeServiceImpl implements TreeServiceI {
    @Override
    public TreeResponseDTO save(TreeRequestDTO requestDTO) {
        return null;
    }

    @Override
    public TreeResponseDTO update(Long id, TreeRequestDTO requestDTO) {
        return null;
    }

    @Override
    public TreeResponseDTO delete(Long id) {
        return null;
    }

    @Override
    public TreeResponseDTO findbyId(Long id) {
        return null;
    }

    @Override
    public List<TreeResponseDTO> findAll() {
        return List.of();
    }
}
