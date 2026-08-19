package cinema.movies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Personne;
import cinema.movies.service.PersonneService;

@RestController
@RequestMapping("/api/personnes")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping
    public List<Personne> getAllPersonnes() {
        return personneService.getListAll();
    }

    @GetMapping("/{id}")
    public Personne getPersonneById(@PathVariable Long id) {
        return personneService.get(id);
    }

    @PostMapping
    public Personne createPersonne(@RequestBody Personne personne) {
        return personneService.save(personne);
    }

    @PutMapping("/{id}")
    public Personne updatePersonne(
            @PathVariable Long id,
            @RequestBody Personne personne) {

        personne.setId(id);
        personneService.update(personne);

        return personneService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deletePersonne(@PathVariable Long id) {
        personneService.delete(id);
    }
}