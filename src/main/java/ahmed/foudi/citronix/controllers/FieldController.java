package ahmed.foudi.citronix.controllers;

import ahmed.foudi.citronix.dto.field.FieldRequestDTO;
import ahmed.foudi.citronix.dto.field.FieldResponseDTO;
import ahmed.foudi.citronix.services.interfaces.FieldServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fields")
@RequiredArgsConstructor
public class FieldController {

    private final FieldServiceI fieldService;

    @PostMapping
    public ResponseEntity<FieldResponseDTO> createField(@RequestBody FieldRequestDTO request) {
        return new ResponseEntity<>(fieldService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FieldResponseDTO>> getAllFields() {
        return ResponseEntity.ok(fieldService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> getFieldById(@PathVariable Long id) {
        return ResponseEntity.ok(fieldService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> updateField(
            @PathVariable Long id,
            @RequestBody FieldRequestDTO request) {
        return ResponseEntity.ok(fieldService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> deleteField(@PathVariable Long id) {
        return ResponseEntity.ok(fieldService.delete(id));
    }
}
