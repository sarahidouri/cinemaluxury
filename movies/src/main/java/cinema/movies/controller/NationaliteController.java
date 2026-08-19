package cinema.movies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import cinema.movies.dto.NationaliteDTO;
import cinema.movies.model.Nationalite;
import cinema.movies.service.NationaliteService;

@RestController
@RequestMapping("/api/nationalites")
@CrossOrigin(origins = "http://localhost:4200")
public class NationaliteController {

    private final NationaliteService nationaliteService;

    public NationaliteController(NationaliteService nationaliteService) {
        this.nationaliteService = nationaliteService;
    }

    @GetMapping
    public List<NationaliteDTO> getAllNationalites() {
        return nationaliteService.getListAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public NationaliteDTO getNationaliteById(@PathVariable Long id) {
        return toDTO(nationaliteService.get(id));
    }

    @PostMapping
    public NationaliteDTO createNationalite(@RequestBody NationaliteDTO dto) {

        Nationalite nationalite = toEntity(dto);

        return toDTO(nationaliteService.save(nationalite));
    }

    @PutMapping("/{id}")
    public NationaliteDTO updateNationalite(
            @PathVariable Long id,
            @RequestBody NationaliteDTO dto) {

        Nationalite nationalite = toEntity(dto);
        nationalite.setId(id);

        nationaliteService.update(nationalite);

        return toDTO(nationaliteService.get(id));
    }

    @DeleteMapping("/{id}")
    public void deleteNationalite(@PathVariable Long id) {
        nationaliteService.delete(id);
    }

    private NationaliteDTO toDTO(Nationalite nationalite) {
        return new NationaliteDTO(
                nationalite.getId(),
                nationalite.getLibelle()
        );
    }

    private Nationalite toEntity(NationaliteDTO dto) {

        Nationalite nationalite = new Nationalite();

        nationalite.setId(dto.getId());
        nationalite.setLibelle(dto.getLibelle());

        return nationalite;
    }
}
