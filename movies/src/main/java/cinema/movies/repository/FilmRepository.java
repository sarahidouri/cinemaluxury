package cinema.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//import cinema.movies.dto.InlineFilm;
import cinema.movies.model.Film;

@CrossOrigin("http://localhost:4200")
@Repository
//@RepositoryRestResource(excerptProjection = InlineFilm.class)
@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long> {

}


