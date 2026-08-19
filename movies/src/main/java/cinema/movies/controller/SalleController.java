package cinema.movies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Salle;
import cinema.movies.service.SalleService;

@RestController
@RequestMapping("/api/salles")
@CrossOrigin(origins = "http://localhost:4200")
public class SalleController {

    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<Salle> getAllSalles() {
        return salleService.getListAll();
    }

    @GetMapping("/{id}")
    public Salle getSalleById(@PathVariable Long id) {
        return salleService.get(id);
    }

    @PostMapping
    public Salle createSalle(@RequestBody Salle salle) {
        return salleService.save(salle);
    }

    @PutMapping("/{id}")
    public Salle updateSalle(
            @PathVariable Long id,
            @RequestBody Salle salle) {

        salle.setId(id);
        salleService.update(salle);

        return salleService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable Long id) {
        salleService.delete(id);
    }
}