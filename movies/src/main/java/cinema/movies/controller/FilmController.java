package cinema.movies.controller;
	 
	import cinema.movies.model.Film;

	import cinema.movies.service.FilmService;

	import org.springframework.http.ResponseEntity;

	import org.springframework.web.bind.annotation.*;
	 
	import java.util.List;
	 
	@RestController

	@RequestMapping("/api/films")

	@CrossOrigin(origins = "http://localhost:4200")

	public class FilmController {
	 
	    private final FilmService filmService;
	 
	    public FilmController(FilmService filmService) {

	        this.filmService = filmService;

	    }
	 
	    @GetMapping

	    public List<Film> getAllFilms() {

	        return filmService.findAll();

	    }
	 
	    @GetMapping("/{id}")

	    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {

	        return filmService.findById(id)

	                .map(ResponseEntity::ok)

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @PostMapping

	    public Film createFilm(@RequestBody Film film) {

	        return filmService.save(film);

	    }
	 
	    @PutMapping("/{id}")

	    public ResponseEntity<Film> updateFilm(

	            @PathVariable Long id,

	            @RequestBody Film film) {
	 
	        return filmService.findById(id)

	                .map(existingFilm -> {

	                    film.setId(id);

	                    return ResponseEntity.ok(filmService.save(film));

	                })

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @DeleteMapping("/{id}")

	    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
	 
	        if (filmService.findById(id).isEmpty()) {

	            return ResponseEntity.notFound().build();

	        }
	 
	        filmService.deleteById(id);

	        return ResponseEntity.noContent().build();

	    }

	}
	 