package cinema.movies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import cinema.movies.dto.FilmDTO;
import cinema.movies.model.Film;
import cinema.movies.service.FilmService;

@RestController
@RequestMapping("/api/films")
@CrossOrigin(origins = "http://localhost:4200")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<FilmDTO> getAllFilms() {
        return filmService.getListAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FilmDTO getFilmById(@PathVariable Long id) {
        return toDTO(filmService.get(id));
    }

    @PostMapping
    public FilmDTO createFilm(@RequestBody FilmDTO dto) {

        Film film = toEntity(dto);

        return toDTO(filmService.save(film));
    }

    @PutMapping("/{id}")
    public FilmDTO updateFilm(
            @PathVariable Long id,
            @RequestBody FilmDTO dto) {

        Film film = toEntity(dto);
        film.setId(id);

        filmService.update(film);

        return toDTO(filmService.get(id));
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmService.delete(id);
    }

    private FilmDTO toDTO(Film film) {

        return new FilmDTO(
                film.getId(),
                film.getTitre(),
                film.getDuree(),
                film.getAnnee(),
                film.getGenre() != null ? film.getGenre().getId() : null,
                film.getNationalite() != null ? film.getNationalite().getId() : null,
                film.getRealisateur() != null ? film.getRealisateur().getId() : null,
                film.getActeurs() != null
                        ? film.getActeurs()
                                .stream()
                                .map(a -> a.getId())
                                .collect(Collectors.toList())
                        : null,
                film.getAddedDate()
        );
    }

    private Film toEntity(FilmDTO dto) {

        Film film = new Film();

        film.setId(dto.getId());
        film.setTitre(dto.getTitre());
        film.setDuree(dto.getDuree());
        film.setAnnee(dto.getAnnee());

        return film;
    }
}