package cinema.movies.service;

	import cinema.movies.model.Media;
	import cinema.movies.repository.MediaRepository;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Service;

	@Service
	public class MediaService extends AbstractService<Media, Long> {

	    @Autowired
	    private MediaRepository mediaRepository;

	    @Override
	    protected JpaRepository<Media, Long> getRepository() {
	        return mediaRepository;
	    }

	}

