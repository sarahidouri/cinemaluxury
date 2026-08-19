package cinema.movies.controller.Admin;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Acteur;
import cinema.movies.service.ActeurService;

@RestController
@RequestMapping("/admin/acteurs")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminActeurController {

    private final ActeurService acteurService;

    public AdminActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    @GetMapping
    public List<Acteur> getAllActeurs() {
        return acteurService.getListAll();
    }

    @GetMapping("/{id}")
    public Acteur getActeurById(@PathVariable Long id) {
        return acteurService.get(id);
    }

    @PostMapping
    public Acteur createActeur(@RequestBody Acteur acteur) {
        return acteurService.save(acteur);
    }

    @PutMapping("/{id}")
    public Acteur updateActeur(@PathVariable Long id, @RequestBody Acteur acteur) {
        acteur.setId(id);
        acteurService.update(acteur);
        return acteurService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteActeur(@PathVariable Long id) {
        acteurService.delete(id);
    }
}