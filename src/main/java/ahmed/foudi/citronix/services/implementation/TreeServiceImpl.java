package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.repository.TreeRepository;
import ahmed.foudi.citronix.repository.FieldRepository;
import ahmed.foudi.citronix.dto.tree.TreeRequestDTO;
import ahmed.foudi.citronix.dto.tree.TreeResponseDTO;
import ahmed.foudi.citronix.entities.Tree;
import ahmed.foudi.citronix.entities.Field;
import ahmed.foudi.citronix.exception.treeexception.PlantingDateException;
import ahmed.foudi.citronix.exception.treeexception.TreeDensityException;
import ahmed.foudi.citronix.mappers.tree.TreeDtoMapper;
import ahmed.foudi.citronix.services.interfaces.TreeServiceI;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TreeServiceImpl implements TreeServiceI {
    
    private final TreeRepository treeRepository;
    private final FieldRepository fieldRepository;
    private final TreeDtoMapper treeDtoMapper;

    @Override
    public TreeResponseDTO save(TreeRequestDTO requestDTO) {
        Tree tree = treeDtoMapper.toEntity(requestDTO);
        ValidatePlantingDate(requestDTO.getPlantingDate());
        Field field = fieldRepository.findById(requestDTO.getFieldId())
                .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + requestDTO.getFieldId()));
        ValidateTreeDensity(field);
        if (requestDTO.getPlantingDate().isBefore(field.getFarm().getDateCreation())) {
            throw new PlantingDateException("La date de plantation ne peut pas être antérieure à la date de création de la ferme.");
        }
        tree.setField(field);
        Tree savedTree = treeRepository.save(tree);
        return treeDtoMapper.toDto(savedTree);
    }

    public void ValidateTreeDensity(Field field){

        double nombreArbre=field.getTrees().size();
        double surface=field.getSurface();
        double surfaceParHectare=surface/10000;
        double maxTreeDensity=surfaceParHectare*100;
        if(nombreArbre+1>maxTreeDensity){
            throw new TreeDensityException("Chaque champ doit contenir un nombre d'arbres telque la densité maximale est de 100 arbres par hectare (10 arbres par 1 000 m²).");
        }
    }

    private void ValidatePlantingDate(LocalDate plantingDate){
        int monthValue=plantingDate.getMonthValue();
        if(monthValue<3||monthValue>5){
            throw new PlantingDateException("Les arbres ne peuvent être plantés qu'entre les mois de mars et mai, période idéale pour le climat.");
        }
    }

    @Override
    public TreeResponseDTO update(Long id, TreeRequestDTO requestDTO) {
        Tree existingTree = treeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tree not found with id: " + id));
        ValidatePlantingDate(requestDTO.getPlantingDate());
        existingTree.setPlantingDate(requestDTO.getPlantingDate());
        
        if (requestDTO.getFieldId() != null && 
            !requestDTO.getFieldId().equals(existingTree.getField().getId())) {
            Field newField = fieldRepository.findById(requestDTO.getFieldId())
                    .orElseThrow(() -> new EntityNotFoundException("Field not found with id: " + requestDTO.getFieldId()));
            existingTree.setField(newField);
        }
        
        Tree updatedTree = treeRepository.save(existingTree);
        return treeDtoMapper.toDto(updatedTree);
    }

    @Override
    public TreeResponseDTO delete(Long id) {
        Tree tree = treeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tree not found with id: " + id));
        TreeResponseDTO response = treeDtoMapper.toDto(tree);
        treeRepository.deleteById(id);
        return response;
    }

    @Override
    public TreeResponseDTO findbyId(Long id) {
        Tree tree = treeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tree not found with id: " + id));
        return treeDtoMapper.toDto(tree);
    }

    @Override
    public List<TreeResponseDTO> findAll() {
        return treeRepository.findAll().stream()
                .map(treeDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
