package cinema.movies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Seance;
import cinema.movies.service.SeanceService;

@RestController
@RequestMapping("/api/seances")
@CrossOrigin(origins = "http://localhost:4200")
public class SeanceController {

    private final SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping
    public List<Seance> getAllSeances() {
        return seanceService.getListAll();
    }

    @GetMapping("/{id}")
    public Seance getSeanceById(@PathVariable Long id) {
        return seanceService.get(id);
    }

    @PostMapping
    public Seance createSeance(@RequestBody Seance seance) {
        return seanceService.save(seance);
    }

    @PutMapping("/{id}")
    public Seance updateSeance(
            @PathVariable Long id,
            @RequestBody Seance seance) {

        seance.setId(id);
        seanceService.update(seance);

        return seanceService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable Long id) {
        seanceService.delete(id);
    }
}