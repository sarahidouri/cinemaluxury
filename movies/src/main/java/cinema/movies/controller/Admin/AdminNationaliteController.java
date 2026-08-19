package cinema.movies.controller.Admin;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Nationalite;
import cinema.movies.service.NationaliteService;

@RestController
@RequestMapping("/admin/nationalites")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminNationaliteController {

    private final NationaliteService nationaliteService;

    public AdminNationaliteController(NationaliteService nationaliteService) {
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