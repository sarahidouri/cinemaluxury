package cinema.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.movies.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
}



