package cinema.movies.controller.Admin;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Film;
import cinema.movies.service.FilmService;

@RestController
@RequestMapping("/admin/films")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminFilmController {

    private final FilmService filmService;

    public AdminFilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> getAllFilms() {
        return filmService.getListAll();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.get(id);
    }

    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmService.save(film);
    }

    @PutMapping("/{id}")
    public Film updateFilm(@PathVariable Long id, @RequestBody Film film) {
        film.setId(id);
        filmService.update(film);
        return filmService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmService.delete(id);
    }
}
