package cinema.movies.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import cinema.movies.dto.CustomersDTO;
import cinema.movies.model.Customers;
import cinema.movies.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomersController {

    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomersDTO> getAllCustomers() {
        return customerService.getListAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomersDTO getCustomerById(@PathVariable Long id) {
        return toDTO(customerService.get(id));
    }

    @PostMapping
    public CustomersDTO createCustomer(@RequestBody CustomersDTO dto) {

        Customers customer = toEntity(dto);

        return toDTO(customerService.save(customer));
    }

    @PutMapping("/{id}")
    public CustomersDTO updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomersDTO dto) {

        Customers customer = toEntity(dto);
        customer.setId(id);

        customerService.update(customer);

        return toDTO(customerService.get(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }

    private CustomersDTO toDTO(Customers customer) {
    	return new CustomersDTO(
    			customer.getId(), 
    			customer.getFirstname(), 
    			customer.getLastname(), 
    			customer.getEmail(), 
    			customer.getAddedDate());
         
    }

    private Customers toEntity(CustomersDTO dto) {
        Customers customer = new Customers();

        customer.setId(dto.getId());
        customer.setFirstname(dto.getFirstname());
        customer.setLastname(dto.getLastname());
        customer.setEmail(dto.getEmail());

        return customer;
    }
}