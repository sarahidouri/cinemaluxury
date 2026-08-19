package cinema.movies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import cinema.movies.dto.GenreDTO;
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
    public List<GenreDTO> getAllGenres() {
        return genreService.getListAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GenreDTO getGenreById(@PathVariable Long id) {
        return toDTO(genreService.get(id));
    }

    @PostMapping
    public GenreDTO createGenre(@RequestBody GenreDTO dto) {

        Genre genre = toEntity(dto);

        return toDTO(genreService.save(genre));
    }

    @PutMapping("/{id}")
    public GenreDTO updateGenre(
            @PathVariable Long id,
            @RequestBody GenreDTO dto) {

        Genre genre = toEntity(dto);
        genre.setId(id);

        genreService.update(genre);

        return toDTO(genreService.get(id));
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.delete(id);
    }

    private GenreDTO toDTO(Genre genre) {
        return new GenreDTO(
                genre.getId(),
                genre.getLibelle()
        );
    }

    private Genre toEntity(GenreDTO dto) {

        Genre genre = new Genre();

        genre.setId(dto.getId());
        genre.setLibelle(dto.getLibelle());

        return genre;
    }
}