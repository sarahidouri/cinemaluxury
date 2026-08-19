package cinema.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.movies.model.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

}