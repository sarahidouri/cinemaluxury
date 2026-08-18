package cinema.movies.controller;
	 
	import cinema.movies.model.Salle;

	import cinema.movies.service.SalleService;

	import org.springframework.http.ResponseEntity;

	import org.springframework.web.bind.annotation.*;
	 
	import java.util.List;
	 
	@RestController

	@RequestMapping("/api/salles")

	@CrossOrigin(origins = "http://localhost:4200")

	public class SalleController {
	 
	    private final SalleService salleService;
	 
	    public SalleController(SalleService salleService) {

	        this.salleService = salleService;

	    }
	 
	    @GetMapping

	    public List<Salle> getAllSalles() {

	        return salleService.findAll();

	    }
	 
	    @GetMapping("/{id}")

	    public ResponseEntity<Salle> getSalleById(@PathVariable Long id) {

	        return salleService.findById(id)

	                .map(ResponseEntity::ok)

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @PostMapping

	    public Salle createSalle(@RequestBody Salle salle) {

	        return salleService.save(salle);

	    }
	 
	    @PutMapping("/{id}")

	    public ResponseEntity<Salle> updateSalle(

	            @PathVariable Long id,

	            @RequestBody Salle salle) {
	 
	        return salleService.findById(id)

	                .map(existingSalle -> {

	                    salle.setId(id);

	                    return ResponseEntity.ok(

	                            salleService.save(salle)

	                    );

	                })

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @DeleteMapping("/{id}")

	    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
	 
	        if (salleService.findById(id).isEmpty()) {

	            return ResponseEntity.notFound().build();

	        }
	 
	        salleService.deleteById(id);

	        return ResponseEntity.noContent().build();

	    }

	}
	 