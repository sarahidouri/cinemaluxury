package cinema.movies.config;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import cinema.movies.model.Film;
import cinema.movies.model.Genre;
import cinema.movies.model.Nationalite;
import cinema.movies.model.Personne;
import cinema.movies.model.Personne.TypePersonne;
import cinema.movies.model.Salle;
import cinema.movies.repository.FilmRepository;
import cinema.movies.repository.GenreRepository;
import cinema.movies.repository.NationaliteRepository;
import cinema.movies.repository.PersonneRepository;
import cinema.movies.repository.SalleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Initializer {

    private final GenreRepository genreRepository;
    private final NationaliteRepository nationaliteRepository;
    private final PersonneRepository personneRepository;
    private final FilmRepository filmRepository;
    private final SalleRepository salleRepository;

    @PostConstruct
    public void init() {

        if (filmRepository.count() > 0) {
            return;
        }

        // Genres
        Genre action = new Genre();
        action.setLibelle("Action");

        Genre drama = new Genre();
        drama.setLibelle("Drama");

        genreRepository.saveAll(List.of(action, drama));

        // Nationalités
        Nationalite american = new Nationalite();
        american.setLibelle("American");

        Nationalite british = new Nationalite();
        british.setLibelle("British");

        nationaliteRepository.saveAll(List.of(american, british));

        // Réalisateur
        Personne nolan = new Personne();
        nolan.setNom("Nolan");
        nolan.setPrenom("Christopher");
        nolan.setDateNaissance(Date.valueOf("1970-07-30"));
        nolan.setTypePersonne(TypePersonne.REALISATEUR);
        nolan.setNationalite(british);

        personneRepository.save(nolan);

        // Acteur
        Personne dicaprio = new Personne();
        dicaprio.setNom("DiCaprio");
        dicaprio.setPrenom("Leonardo");
        dicaprio.setDateNaissance(Date.valueOf("1974-11-11"));
        dicaprio.setTypePersonne(TypePersonne.ACTEUR);
        dicaprio.setNationalite(american);

        personneRepository.save(dicaprio);

        // Film
        Film inception = new Film();
        inception.setTitre("Inception");
        inception.setAnnee(2010);
        inception.setDuree(148);
        inception.setGenre(action);
        inception.setNationalite(american);
        inception.setRealisateur(nolan);
        inception.setActeurs(List.of(dicaprio));

        filmRepository.save(inception);

        // Salle
        Salle salle1 = new Salle();
        salle1.setNumero(1);
        salle1.setCapacite(150);

        Salle salle2 = new Salle();
        salle2.setNumero(2);
        salle2.setCapacite(200);

        salleRepository.saveAll(List.of(salle1, salle2));
    }
}
