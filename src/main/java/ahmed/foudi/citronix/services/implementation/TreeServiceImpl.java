package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dao.TreeDAO;
import ahmed.foudi.citronix.dao.FieldDAO;
import ahmed.foudi.citronix.dto.tree.TreeRequestDTO;
import ahmed.foudi.citronix.dto.tree.TreeResponseDTO;
import ahmed.foudi.citronix.entities.Tree;
import ahmed.foudi.citronix.entities.Field;
import ahmed.foudi.citronix.mappers.tree.TreeDtoMapper;
import ahmed.foudi.citronix.services.interfaces.TreeServiceI;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TreeServiceImpl implements TreeServiceI {
    
    private final TreeDAO treeDAO;
    private final FieldDAO fieldDAO;
    private final TreeDtoMapper treeDtoMapper;

    @Override
    public TreeResponseDTO save(TreeRequestDTO requestDTO) {
        Tree tree = treeDtoMapper.toEntity(requestDTO);
        
        Field field = fieldDAO.findById(requestDTO.getFieldId())
                .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + requestDTO.getFieldId()));
        tree.setField(field);
        
        Tree savedTree = treeDAO.save(tree);
        return treeDtoMapper.toDto(savedTree);
    }

    @Override
    public TreeResponseDTO update(Long id, TreeRequestDTO requestDTO) {
        Tree existingTree = treeDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tree not found with id: " + id));
        
        existingTree.setPlantingDate(requestDTO.getPlantingDate());
        
        if (requestDTO.getFieldId() != null && 
            !requestDTO.getFieldId().equals(existingTree.getField().getId())) {
            Field newField = fieldDAO.findById(requestDTO.getFieldId())
                    .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + requestDTO.getFieldId()));
            existingTree.setField(newField);
        }
        
        Tree updatedTree = treeDAO.save(existingTree);
        return treeDtoMapper.toDto(updatedTree);
    }

    @Override
    public TreeResponseDTO delete(Long id) {
        Tree tree = treeDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tree not found with id: " + id));
        TreeResponseDTO response = treeDtoMapper.toDto(tree);
        treeDAO.deleteById(id);
        return response;
    }

    @Override
    public TreeResponseDTO findbyId(Long id) {
        Tree tree = treeDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tree not found with id: " + id));
        return treeDtoMapper.toDto(tree);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TreeResponseDTO> findAll() {
        return treeDAO.findAll().stream()
                .map(treeDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
