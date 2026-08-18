package cinema.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Nationalite;
import cinema.movies.repository.NationaliteRepository;

@RestController
@RequestMapping("/nationalites")
@CrossOrigin("http://localhost:4200")
public class NationaliteController {

    @Autowired
    private NationaliteRepository repository;

    @GetMapping
    public Page<Nationalite> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return repository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Nationalite getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Nationalite create(@RequestBody Nationalite nationalite) {
        return repository.save(nationalite);
    }

    @PutMapping("/{id}")
    public Nationalite update(
            @PathVariable Long id,
            @RequestBody Nationalite nationalite) {

        nationalite.setId(id);
        return repository.save(nationalite);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/search")
    public Page<Nationalite> search(
            @RequestParam String libelle,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return repository.findByLibelleStartsWith(
                libelle,
                PageRequest.of(page, size));
    }
}