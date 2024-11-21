package ahmed.foudi.citronix.services.implementation;

import ahmed.foudi.citronix.dao.HarvestDetailDAO;
import ahmed.foudi.citronix.dao.TreeDAO;
import ahmed.foudi.citronix.dao.HarvestDAO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsRequestDTO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsResponseDTO;

import ahmed.foudi.citronix.entities.EmbdedId;
import ahmed.foudi.citronix.entities.HarvestDetails;
import ahmed.foudi.citronix.entities.Tree;
import ahmed.foudi.citronix.entities.Harvest;

import ahmed.foudi.citronix.mappers.harvestdetails.HarvestDetailsDtoMapper;
import ahmed.foudi.citronix.services.interfaces.HarvestDetailServiceI;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HarvestDetailServiceImpl implements HarvestDetailServiceI {
    
    private final HarvestDetailDAO harvestDetailDAO;
    private final TreeDAO treeDAO;
    private final HarvestDAO harvestDAO;
    private final HarvestDetailsDtoMapper harvestDetailDtoMapper;

    @Override
    public HarvestDetailsResponseDTO save(HarvestDetailsRequestDTO requestDTO) {
        Tree tree = treeDAO.findById(requestDTO.getTreeId())
                .orElseThrow(() -> new EntityNotFoundException("Tree not found with id: " + requestDTO.getTreeId()));
        Harvest harvest = harvestDAO.findById(requestDTO.getHarvestId())
                .orElseThrow(() -> new EntityNotFoundException("Harvest not found with id: " + requestDTO.getHarvestId()));

        HarvestDetails harvestDetail = harvestDetailDtoMapper.toEntity(requestDTO);
        harvestDetail.setTree(tree);
        harvestDetail.setHarvest(harvest);
        
        EmbdedId embdedId = new EmbdedId();
        embdedId.setTreeId(requestDTO.getTreeId());
        embdedId.setHarvestId(requestDTO.getHarvestId());
        harvestDetail.setId(embdedId);
        
        HarvestDetails savedDetail = harvestDetailDAO.save(harvestDetail);
        return harvestDetailDtoMapper.toDto(savedDetail);
    }

    @Override
    public HarvestDetailsResponseDTO update(Long treeId, Long harvestId, HarvestDetailsRequestDTO requestDTO) {
        EmbdedId embdedId = new EmbdedId();
        embdedId.setTreeId(treeId);
        embdedId.setHarvestId(harvestId);
        
        HarvestDetails existingDetail = harvestDetailDAO.findById(embdedId)
                .orElseThrow(() -> new EntityNotFoundException("HarvestDetail not found for treeId: " + treeId + " and harvestId: " + harvestId));
        
        existingDetail.setQuantity(requestDTO.getQuantity());
        
        HarvestDetails updatedDetail = harvestDetailDAO.save(existingDetail);
        return harvestDetailDtoMapper.toDto(updatedDetail);
    }

    @Override
    public HarvestDetailsResponseDTO delete(Long treeId, Long harvestId) {
        EmbdedId embdedId = new EmbdedId();
        embdedId.setTreeId(treeId);
        embdedId.setHarvestId(harvestId);
        
        HarvestDetails detail = harvestDetailDAO.findById(embdedId)
                .orElseThrow(() -> new EntityNotFoundException("HarvestDetail not found for treeId: " + treeId + " and harvestId: " + harvestId));
        HarvestDetailsResponseDTO response = harvestDetailDtoMapper.toDto(detail);
        harvestDetailDAO.deleteById(embdedId);
        return response;
    }

    @Override
    public HarvestDetailsResponseDTO findById(Long treeId, Long harvestId) {
        EmbdedId embdedId = new EmbdedId();
        embdedId.setTreeId(treeId);
        embdedId.setHarvestId(harvestId);
        
        HarvestDetails detail = harvestDetailDAO.findById(embdedId)
                .orElseThrow(() -> new EntityNotFoundException("HarvestDetail not found for treeId: " + treeId + " and harvestId: " + harvestId));
        return harvestDetailDtoMapper.toDto(detail);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HarvestDetailsResponseDTO> findAll() {
        return harvestDetailDAO.findAll().stream()
                .map(harvestDetailDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
