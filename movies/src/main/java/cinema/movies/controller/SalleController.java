package cinema.movies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import cinema.movies.dto.SalleDTO;
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
    public List<SalleDTO> getAllSalles() {
        return salleService.getListAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SalleDTO getSalleById(@PathVariable Long id) {
        return toDTO(salleService.get(id));
    }

    @PostMapping
    public SalleDTO createSalle(@RequestBody SalleDTO dto) {

        Salle salle = toEntity(dto);

        return toDTO(salleService.save(salle));
    }

    @PutMapping("/{id}")
    public SalleDTO updateSalle(
            @PathVariable Long id,
            @RequestBody SalleDTO dto) {

        Salle salle = toEntity(dto);
        salle.setId(id);

        salleService.update(salle);

        return toDTO(salleService.get(id));
    }

    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable Long id) {
        salleService.delete(id);
    }

    private SalleDTO toDTO(Salle salle) {

        return new SalleDTO(
                salle.getId(),
                salle.getNumero(),
                salle.getCapacite(),
                salle.getAddedDate()
        );
    }

    private Salle toEntity(SalleDTO dto) {

        Salle salle = new Salle();

        salle.setId(dto.getId());
        salle.setNumero(dto.getNumero());
        salle.setCapacite(dto.getCapacite());

        return salle;
    }
}