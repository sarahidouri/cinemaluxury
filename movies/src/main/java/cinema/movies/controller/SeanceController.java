package cinema.movies.controller;
	 
	import cinema.movies.model.Seance;

	import cinema.movies.service.SeanceService;

	import org.springframework.http.ResponseEntity;

	import org.springframework.web.bind.annotation.*;
	 
	import java.util.List;
	 
	@RestController

	@RequestMapping("/api/seances")

	@CrossOrigin(origins = "http://localhost:4200")

	public class SeanceController {
	 
	    private final SeanceService seanceService;
	 
	    public SeanceController(SeanceService seanceService) {

	        this.seanceService = seanceService;

	    }
	 
	    @GetMapping

	    public List<Seance> getAllSeances() {

	        return seanceService.findAll();

	    }
	 
	    @GetMapping("/{id}")

	    public ResponseEntity<Seance> getSeanceById(

	            @PathVariable Long id) {
	 
	        return seanceService.findById(id)

	                .map(ResponseEntity::ok)

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @PostMapping

	    public Seance createSeance(@RequestBody Seance seance) {

	        return seanceService.save(seance);

	    }
	 
	    @PutMapping("/{id}")

	    public ResponseEntity<Seance> updateSeance(

	            @PathVariable Long id,

	            @RequestBody Seance seance) {
	 
	        return seanceService.findById(id)

	                .map(existingSeance -> {

	                    seance.setId(id);

	                    return ResponseEntity.ok(

	                            seanceService.save(seance)

	                    );

	                })

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @DeleteMapping("/{id}")

	    public ResponseEntity<Void> deleteSeance(

	            @PathVariable Long id) {
	 
	        if (seanceService.findById(id).isEmpty()) {

	            return ResponseEntity.notFound().build();

	        }
	 
	        seanceService.deleteById(id);

	        return ResponseEntity.noContent().build();

	    }

	}
	 