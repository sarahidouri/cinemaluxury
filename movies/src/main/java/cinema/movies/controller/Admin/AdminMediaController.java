package cinema.movies.controller.Admin;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Media;
import cinema.movies.service.MediaService;

@RestController
@RequestMapping("/admin/medias")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminMediaController {

    private final MediaService mediaService;

    public AdminMediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public List<Media> getAllMedias() {
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