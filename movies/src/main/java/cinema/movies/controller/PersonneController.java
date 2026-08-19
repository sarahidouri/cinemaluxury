package cinema.movies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import cinema.movies.dto.PersonneDTO;
import cinema.movies.model.Personne;
import cinema.movies.service.NationaliteService;
import cinema.movies.service.PersonneService;

@RestController
@RequestMapping("/api/personnes")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonneController {

    private final PersonneService personneService;
    private final NationaliteService nationaliteService;

    public PersonneController(
            PersonneService personneService,
            NationaliteService nationaliteService) {

        this.personneService = personneService;
        this.nationaliteService = nationaliteService;
    }

    @GetMapping
    public List<PersonneDTO> getAllPersonnes() {
        return personneService.getListAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonneDTO getPersonneById(@PathVariable Long id) {
        return toDTO(personneService.get(id));
    }

    @PostMapping
    public PersonneDTO createPersonne(@RequestBody PersonneDTO dto) {

        Personne personne = toEntity(dto);

        return toDTO(personneService.save(personne));
    }

    @PutMapping("/{id}")
    public PersonneDTO updatePersonne(
            @PathVariable Long id,
            @RequestBody PersonneDTO dto) {

        Personne personne = toEntity(dto);
        personne.setId(id);

        personneService.update(personne);

        return toDTO(personneService.get(id));
    }

    @DeleteMapping("/{id}")
    public void deletePersonne(@PathVariable Long id) {
        personneService.delete(id);
    }

    private PersonneDTO toDTO(Personne personne) {

        return new PersonneDTO(
                personne.getId(),
                personne.getNom(),
                personne.getPrenom(),
                personne.getPhoto(),
                personne.getDateNaissance(),
                personne.getTypePersonne(),
                personne.getAddedDate(),
                personne.getNationalite() != null
                        ? personne.getNationalite().getId()
                        : null
        );
    }

    private Personne toEntity(PersonneDTO dto) {

        Personne personne = new Personne();

        personne.setId(dto.getId());
        personne.setNom(dto.getNom());
        personne.setPrenom(dto.getPrenom());
        personne.setPhoto(dto.getPhoto());
        personne.setDateNaissance(dto.getDateNaissance());
        personne.setTypePersonne(dto.getTypePersonne());

        if (dto.getNationaliteId() != null) {
            personne.setNationalite(
                    nationaliteService.get(dto.getNationaliteId())
            );
        }

        return personne;
    }
}