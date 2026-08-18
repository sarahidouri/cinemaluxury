package cinema.movies.controller;
	 
	import cinema.movies.model.Media;

	import cinema.movies.service.MediaService;

	import org.springframework.http.ResponseEntity;

	import org.springframework.web.bind.annotation.*;
	 
	import java.util.List;
	 
	@RestController

	@RequestMapping("/api/media")

	@CrossOrigin(origins = "http://localhost:4200")

	public class MediaController {
	 
	    private final MediaService mediaService;
	 
	    public MediaController(MediaService mediaService) {

	        this.mediaService = mediaService;

	    }
	 
	    @GetMapping

	    public List<Media> getAllMedia() {

	        return mediaService.findAll();

	    }
	 
	    @GetMapping("/{id}")

	    public ResponseEntity<Media> getMediaById(@PathVariable Long id) {

	        return mediaService.findById(id)

	                .map(ResponseEntity::ok)

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @PostMapping

	    public Media createMedia(@RequestBody Media media) {

	        return mediaService.save(media);

	    }
	 
	    @PutMapping("/{id}")

	    public ResponseEntity<Media> updateMedia(

	            @PathVariable Long id,

	            @RequestBody Media media) {
	 
	        return mediaService.findById(id)

	                .map(existingMedia -> {

	                    media.setId(id);

	                    return ResponseEntity.ok(mediaService.save(media));

	                })

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @DeleteMapping("/{id}")

	    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
	 
	        if (mediaService.findById(id).isEmpty()) {

	            return ResponseEntity.notFound().build();

	        }
	 
	        mediaService.deleteById(id);

	        return ResponseEntity.noContent().build();

	    }

	}
	 