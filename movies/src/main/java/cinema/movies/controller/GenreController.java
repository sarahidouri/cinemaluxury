package cinema.movies.controller;
 
import cinema.movies.model.Genre;
import cinema.movies.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/api/genres")
@CrossOrigin(origins = "http://localhost:4200")
public class GenreController {
    private final GenreService genreService;
 
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
 
    @GetMapping
    public ResponseEntity<List<Genre>> getAll() {
        return ResponseEntity.ok(genreService.findAll());
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getById(@PathVariable Long id) {
        Optional<Genre> genre = genreService.findById(id);
        return genre.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
 
    @PostMapping
    public ResponseEntity<Genre> create(@RequestBody Genre genre) {
        Genre saved = genreService.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Genre> update(@PathVariable Long id, @RequestBody Genre genre) {
        if (!genreService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        genre.setId(id);
        Genre updated = genreService.save(genre);
        return ResponseEntity.ok(updated);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!genreService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        genreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
 
 