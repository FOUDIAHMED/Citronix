package ahmed.foudi.citronix.controllers;

import ahmed.foudi.citronix.dto.harvest.HarvestRequestDTO;
import ahmed.foudi.citronix.dto.harvest.HarvestResponseDTO;
import ahmed.foudi.citronix.services.interfaces.HarvestServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/harvests")
@RequiredArgsConstructor
public class HarvestController {

    private final HarvestServiceI harvestService;

    @PostMapping
    public ResponseEntity<HarvestResponseDTO> createHarvest(@RequestBody HarvestRequestDTO request) {
        return new ResponseEntity<>(harvestService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HarvestResponseDTO>> getAllHarvests() {
        return ResponseEntity.ok(harvestService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarvestResponseDTO> getHarvestById(@PathVariable Long id) {
        return ResponseEntity.ok(harvestService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HarvestResponseDTO> updateHarvest(
            @PathVariable Long id,
            @RequestBody HarvestRequestDTO request) {
        return ResponseEntity.ok(harvestService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HarvestResponseDTO> deleteHarvest(@PathVariable Long id) {
        return ResponseEntity.ok(harvestService.delete(id));
    }
}
