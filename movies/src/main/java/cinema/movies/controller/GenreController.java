package cinema.movies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Genre;
import cinema.movies.service.GenreService;

@RestController
@RequestMapping("/api/genres")
@CrossOrigin(origins = "http://localhost:4200")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getListAll();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Long id) {
        return genreService.get(id);
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.save(genre);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(
            @PathVariable Long id,
            @RequestBody Genre genre) {

        genre.setId(id);
        genreService.update(genre);

        return genreService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.delete(id);
    }
}