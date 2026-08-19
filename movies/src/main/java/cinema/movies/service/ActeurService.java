
package cinema.movies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cinema.movies.model.Acteur;
import cinema.movies.repository.ActeurRepository;

@Service
public class ActeurService {

    private final ActeurRepository acteurRepository;

    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public List<Acteur> getListAll() {
        return acteurRepository.findAll();
    }

    public Acteur get(Long id) {
        return acteurRepository.findById(id).orElse(null);
    }

    public Acteur save(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    public Acteur update(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    public void delete(Long id) {
        acteurRepository.deleteById(id);
    }
}