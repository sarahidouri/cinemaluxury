package cinema.movies.controller;
	 
	import cinema.movies.model.Personne;

	import cinema.movies.service.PersonneService;

	import org.springframework.http.ResponseEntity;

	import org.springframework.web.bind.annotation.*;
	 
	import java.util.List;
	 
	@RestController

	@RequestMapping("/api/personnes")

	@CrossOrigin(origins = "http://localhost:4200")

	public class PersonneController {
	 
	    private final PersonneService personneService;
	 
	    public PersonneController(PersonneService personneService) {

	        this.personneService = personneService;

	    }
	 
	    @GetMapping

	    public List<Personne> getAllPersonnes() {

	        return personneService.findAll();

	    }
	 
	    @GetMapping("/{id}")

	    public ResponseEntity<Personne> getPersonneById(

	            @PathVariable Long id) {
	 
	        return personneService.findById(id)

	                .map(ResponseEntity::ok)

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @PostMapping

	    public Personne createPersonne(@RequestBody Personne personne) {

	        return personneService.save(personne);

	    }
	 
	    @PutMapping("/{id}")

	    public ResponseEntity<Personne> updatePersonne(

	            @PathVariable Long id,

	            @RequestBody Personne personne) {
	 
	        return personneService.findById(id)

	                .map(existingPersonne -> {

	                    personne.setId(id);

	                    return ResponseEntity.ok(

	                            personneService.save(personne)

	                    );

	                })

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @DeleteMapping("/{id}")

	    public ResponseEntity<Void> deletePersonne(

	            @PathVariable Long id) {
	 
	        if (personneService.findById(id).isEmpty()) {

	            return ResponseEntity.notFound().build();

	        }
	 
	        personneService.deleteById(id);

	        return ResponseEntity.noContent().build();

	    }

	}
	 
