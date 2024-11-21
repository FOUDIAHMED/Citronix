package ahmed.foudi.citronix.controllers;

import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsRequestDTO;
import ahmed.foudi.citronix.dto.harvestdetails.HarvestDetailsResponseDTO;
import ahmed.foudi.citronix.services.interfaces.HarvestDetailServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/harvest-details")
@RequiredArgsConstructor
public class HarvestDetailController {

    private final HarvestDetailServiceI harvestDetailService;

    @PostMapping
    public ResponseEntity<HarvestDetailsResponseDTO> createHarvestDetail(
            @RequestBody HarvestDetailsRequestDTO request) {
        return new ResponseEntity<>(harvestDetailService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HarvestDetailsResponseDTO>> getAllHarvestDetails() {
        return ResponseEntity.ok(harvestDetailService.findAll());
    }

    @GetMapping("/{treeId}/{harvestId}")
    public ResponseEntity<HarvestDetailsResponseDTO> getHarvestDetail(
            @PathVariable Long treeId,
            @PathVariable Long harvestId) {
        return ResponseEntity.ok(harvestDetailService.findById(treeId, harvestId));
    }

    @PutMapping("/{treeId}/{harvestId}")
    public ResponseEntity<HarvestDetailsResponseDTO> updateHarvestDetail(
            @PathVariable Long treeId,
            @PathVariable Long harvestId,
            @RequestBody HarvestDetailsRequestDTO request) {
        return ResponseEntity.ok(harvestDetailService.update(treeId, harvestId, request));
    }

    @DeleteMapping("/{treeId}/{harvestId}")
    public ResponseEntity<HarvestDetailsResponseDTO> deleteHarvestDetail(
            @PathVariable Long treeId,
            @PathVariable Long harvestId) {
        return ResponseEntity.ok(harvestDetailService.delete(treeId, harvestId));
    }
}
