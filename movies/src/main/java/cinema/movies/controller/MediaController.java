package cinema.movies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Media;
import cinema.movies.service.MediaService;

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
        return mediaService.getListAll();
    }

    @GetMapping("/{id}")
    public Media getMediaById(@PathVariable Long id) {
        return mediaService.get(id);
    }

    @PostMapping
    public Media createMedia(@RequestBody Media media) {
        return mediaService.save(media);
    }

    @PutMapping("/{id}")
    public Media updateMedia(
            @PathVariable Long id,
            @RequestBody Media media) {

        media.setId(id);
        mediaService.update(media);

        return mediaService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Long id) {
        mediaService.delete(id);
    }
}