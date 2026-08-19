package cinema.movies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import cinema.movies.dto.SeanceDTO;
import cinema.movies.model.Seance;
import cinema.movies.service.FilmService;
import cinema.movies.service.SalleService;
import cinema.movies.service.SeanceService;

@RestController
@RequestMapping("/api/seances")
@CrossOrigin(origins = "http://localhost:4200")
public class SeanceController {

    private final SeanceService seanceService;
    private final FilmService filmService;
    private final SalleService salleService;

    public SeanceController(
            SeanceService seanceService,
            FilmService filmService,
            SalleService salleService) {

        this.seanceService = seanceService;
        this.filmService = filmService;
        this.salleService = salleService;
    }

    @GetMapping
    public List<SeanceDTO> getAllSeances() {
        return seanceService.getListAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SeanceDTO getSeanceById(@PathVariable Long id) {
        return toDTO(seanceService.get(id));
    }

    @PostMapping
    public SeanceDTO createSeance(@RequestBody SeanceDTO dto) {

        Seance seance = toEntity(dto);

        return toDTO(seanceService.save(seance));
    }

    @PutMapping("/{id}")
    public SeanceDTO updateSeance(
            @PathVariable Long id,
            @RequestBody SeanceDTO dto) {

        Seance seance = toEntity(dto);
        seance.setId(id);

        seanceService.update(seance);

        return toDTO(seanceService.get(id));
    }

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable Long id) {
        seanceService.delete(id);
    }

    private SeanceDTO toDTO(Seance seance) {

        return new SeanceDTO(
                seance.getId(),
                seance.getDateProjection(),
                seance.getHeureDebut(),
                seance.getHeureFin(),
                seance.getFilm() != null
                        ? seance.getFilm().getId()
                        : null,
                seance.getSalle() != null
                        ? seance.getSalle().getId()
                        : null
        );
    }

    private Seance toEntity(SeanceDTO dto) {

        Seance seance = new Seance();

        seance.setId(dto.getId());
        seance.setDateProjection(dto.getDateProjection());
        seance.setHeureDebut(dto.getHeureDebut());
        seance.setHeureFin(dto.getHeureFin());

        if (dto.getFilmId() != null) {
            seance.setFilm(filmService.get(dto.getFilmId()));
        }

        if (dto.getSalleId() != null) {
            seance.setSalle(salleService.get(dto.getSalleId()));
        }

        return seance;
    }
}
