package cinema.movies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import cinema.movies.dto.MediaDTO;
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
    public List<MediaDTO> getAllMedia() {
        return mediaService.getListAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MediaDTO getMediaById(@PathVariable Long id) {
        return toDTO(mediaService.get(id));
    }

    @PostMapping
    public MediaDTO createMedia(@RequestBody MediaDTO dto) {

        Media media = toEntity(dto);

        return toDTO(mediaService.save(media));
    }

    @PutMapping("/{id}")
    public MediaDTO updateMedia(
            @PathVariable Long id,
            @RequestBody MediaDTO dto) {

        Media media = toEntity(dto);
        media.setId(id);

        mediaService.update(media);

        return toDTO(mediaService.get(id));
    }

    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Long id) {
        mediaService.delete(id);
    }

    private MediaDTO toDTO(Media media) {

        return new MediaDTO(
                media.getId(),
                media.getMedia(),
                media.getTypeMedia(),
                media.getAddedDate(),
                media.getFilm() != null ? media.getFilm().getId() : null
        );
    }

    private Media toEntity(MediaDTO dto) {

        Media media = new Media();

        media.setId(dto.getId());
        media.setMedia(dto.getMedia());
        media.setTypeMedia(dto.getTypeMedia());

        return media;
    }
}