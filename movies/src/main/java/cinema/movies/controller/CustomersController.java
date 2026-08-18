package cinema.movies.controller;
	 
	import cinema.movies.model.Customers;

	import cinema.movies.service.CustomerService;

	import org.springframework.http.ResponseEntity;

	import org.springframework.web.bind.annotation.*;
	 
	import java.util.List;
	 
	@RestController

	@RequestMapping("/api/customers")

	@CrossOrigin(origins = "http://localhost:4200")

	public class CustomersController {
	 
	    private final CustomerService customerService;
	 
	    public CustomerController(CustomerService customerService) {

	        this.customerService = customerService;

	    }
	 
	    @GetMapping

	    public List<Customers> getAllCustomers() {

	        return customerService.findAll();

	    }
	 
	    @GetMapping("/{id}")

	    public ResponseEntity<Customers> getCustomerById(

	            @PathVariable Long id) {
	 
	        return customerService.findById(id)

	                .map(ResponseEntity::ok)

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @PostMapping

	    public Customers createCustomer(

	            @RequestBody Customers customer) {
	 
	        return customerService.save(customer);

	    }
	 
	    @PutMapping("/{id}")

	    public ResponseEntity<Customers> updateCustomer(

	            @PathVariable Long id,

	            @RequestBody Customers customer) {
	 
	        return customerService.findById(id)

	                .map(existingCustomer -> {

	                    customer.setId(id);

	                    return ResponseEntity.ok(

	                            customerService.save(customer)

	                    );

	                })

	                .orElse(ResponseEntity.notFound().build());

	    }
	 
	    @DeleteMapping("/{id}")

	    public ResponseEntity<Void> deleteCustomer(

	            @PathVariable Long id) {
	 
	        if (customerService.findById(id).isEmpty()) {

	            return ResponseEntity.notFound().build();

	        }
	 
	        customerService.deleteById(id);

	        return ResponseEntity.noContent().build();

	    }

	}
	 
