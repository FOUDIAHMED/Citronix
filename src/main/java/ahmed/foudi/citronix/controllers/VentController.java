package ahmed.foudi.citronix.controllers;

import ahmed.foudi.citronix.dto.vent.VentRequestDTO;
import ahmed.foudi.citronix.dto.vent.VentResponseDTO;
import ahmed.foudi.citronix.services.interfaces.VentServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vents")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VentController {

    private final VentServiceI ventService;

    @PostMapping
    public ResponseEntity<VentResponseDTO> createVent(@RequestBody VentRequestDTO request) {
        return new ResponseEntity<>(ventService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VentResponseDTO>> getAllVents() {
        return ResponseEntity.ok(ventService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentResponseDTO> getVentById(@PathVariable Long id) {
        return ResponseEntity.ok(ventService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentResponseDTO> updateVent(
            @PathVariable Long id,
            @RequestBody VentRequestDTO request) {
        return ResponseEntity.ok(ventService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VentResponseDTO> deleteVent(@PathVariable Long id) {
        return ResponseEntity.ok(ventService.delete(id));
    }
}
