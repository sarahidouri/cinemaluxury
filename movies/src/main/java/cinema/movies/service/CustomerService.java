package cinema.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import cinema.movies.model.Customers;
import cinema.movies.repository.CustomerRepository;

@Service
public class CustomerService
        extends AbstractService<Customers, Long> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    protected JpaRepository<Customers, Long> getRepository() {
        return customerRepository;
    }
}