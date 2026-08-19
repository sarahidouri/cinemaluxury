package cinema.movies.controller.Admin;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import cinema.movies.model.Customers;
import cinema.movies.service.CustomerService;

@RestController
@RequestMapping("/admin/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminCustomersController {

    private final CustomerService customerService;

    public AdminCustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customers> getAllCustomers() {
        return customerService.getListAll();
    }

    @GetMapping("/{id}")
    public Customers getCustomerById(@PathVariable Long id) {
        return customerService.get(id);
    }

    @PostMapping
    public Customers createCustomer(@RequestBody Customers customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customers updateCustomer(@PathVariable Long id,
                                    @RequestBody Customers customer) {
        customer.setId(id);
        customerService.update(customer);
        return customerService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }
}