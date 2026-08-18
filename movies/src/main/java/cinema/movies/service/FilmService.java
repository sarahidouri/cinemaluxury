package cinema.movies.service;

	import cinema.movies.model.Film;
	import cinema.movies.repository.FilmRepository;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Service;

	@Service
	public class FilmService extends AbstractService<Film, Long> {

	    @Autowired
	    private FilmRepository filmRepository;

	    @Override
	    protected JpaRepository<Film, Long> getRepository() {
	        return filmRepository;
	    }

	}

