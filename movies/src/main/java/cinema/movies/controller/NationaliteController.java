package cinema.movies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Nationalite;
import cinema.movies.service.NationaliteService;

@RestController
@RequestMapping("/api/nationalites")
@CrossOrigin(origins = "http://localhost:4200")
public class NationaliteController {

    private final NationaliteService nationaliteService;

    public NationaliteController(NationaliteService nationaliteService) {
        this.nationaliteService = nationaliteService;
    }

    @GetMapping
    public List<Nationalite> getAllNationalites() {
        return nationaliteService.getListAll();
    }

    @GetMapping("/{id}")
    public Nationalite getNationaliteById(@PathVariable Long id) {
        return nationaliteService.get(id);
    }

    @PostMapping
    public Nationalite createNationalite(@RequestBody Nationalite nationalite) {
        return nationaliteService.save(nationalite);
    }

    @PutMapping("/{id}")
    public Nationalite updateNationalite(
            @PathVariable Long id,
            @RequestBody Nationalite nationalite) {

        nationalite.setId(id);
        nationaliteService.update(nationalite);

        return nationaliteService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNationalite(@PathVariable Long id) {
        nationaliteService.delete(id);
    }
}