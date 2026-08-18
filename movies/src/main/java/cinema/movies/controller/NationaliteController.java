package cinema.movies.controller;
 
import cinema.movies.model.Nationalite;
import cinema.movies.service.NationaliteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/api/nationalites")
@CrossOrigin(origins = "http://localhost:4200")
public class NationaliteController {
    private final NationaliteService nationaliteService;
 
    public NationaliteController(NationaliteService nationaliteService) {
        this.nationaliteService = nationaliteService;
    }
 
    @GetMapping
    public ResponseEntity<List<Nationalite>> getAll() {
        return ResponseEntity.ok(nationaliteService.findAll());
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Nationalite> getById(@PathVariable Long id) {
        Optional<Nationalite> nationalite = nationaliteService.findById(id);
        return nationalite.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @PostMapping
    public ResponseEntity<Nationalite> create(@RequestBody Nationalite nationalite) {
        Nationalite saved = nationaliteService.save(nationalite);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Nationalite> update(@PathVariable Long id, @RequestBody Nationalite nationalite) {
        if (!nationaliteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        nationalite.setId(id);
        Nationalite updated = nationaliteService.save(nationalite);
        return ResponseEntity.ok(updated);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!nationaliteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        nationaliteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
 
 