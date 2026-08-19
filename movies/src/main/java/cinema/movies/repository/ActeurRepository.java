

package cinema.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.movies.model.Acteur;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Long> {

}