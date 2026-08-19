package cinema.movies.controller.Admin;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.movies.model.Personne;
import cinema.movies.service.PersonneService;


@RestController
@RequestMapping("/admin/realisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminRealisateurController {

    private final PersonneService personneService;

    public AdminRealisateurController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping
    public List<Personne> getAllRealisateurs() {
        return personneService.getListAll();
    }

    @GetMapping("/{id}")
    public Personne getRealisateurById(@PathVariable Long id) {
        return personneService.get(id);
    }

    @PostMapping
    public Personne createRealisateur(@RequestBody Personne realisateur) {
        return personneService.save(realisateur);
    }

    @PutMapping("/{id}")
    public Personne updateRealisateur(@PathVariable Long id,
                                      @RequestBody Personne realisateur) {

        realisateur.setId(id);
        personneService.update(realisateur);

        return personneService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRealisateur(@PathVariable Long id) {
        personneService.delete(id);
    }
}