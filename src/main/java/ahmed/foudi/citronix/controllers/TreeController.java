package ahmed.foudi.citronix.controllers;

import ahmed.foudi.citronix.dto.tree.TreeRequestDTO;
import ahmed.foudi.citronix.dto.tree.TreeResponseDTO;
import ahmed.foudi.citronix.services.interfaces.TreeServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trees")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TreeController {

    private final TreeServiceI treeService;

    @PostMapping
    public ResponseEntity<TreeResponseDTO> createTree(@RequestBody TreeRequestDTO request) {
        return new ResponseEntity<>(treeService.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TreeResponseDTO>> getAllTrees() {
        return ResponseEntity.ok(treeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeResponseDTO> getTreeById(@PathVariable Long id) {
        return ResponseEntity.ok(treeService.findbyId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreeResponseDTO> updateTree(
            @PathVariable Long id,
            @RequestBody TreeRequestDTO request) {
        return ResponseEntity.ok(treeService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TreeResponseDTO> deleteTree(@PathVariable Long id) {
        return ResponseEntity.ok(treeService.delete(id));
    }
}
