package mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerAPI {

    private static final Logger log = LoggerFactory.getLogger(CustomerAPI.class);

    @Autowired
    CustomerRepository customerRepository;



    /*
    // Does not post. How do I post?
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void remove() {
        repository.deleteAll();
    }

    @RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET)
    public Customer getSpecificCustomer(@PathVariable String firstName, @PathVariable String lastName) {
        for (Customer customer : repository.findAll()) {
            if (customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName)) {
                return customer;
            }
        }
        return null;
    }
    */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Customer listAll() {
        populateRepo();
        for (Customer customer : customerRepository.findAll()) {
            log.info(customer.toString());
        }
        return null;
    }

    public void populateRepo() {
        // Start clean
        customerRepository.deleteAll();

        // Save some test-customers
        customerRepository.save(new Customer("Martin", "Kamb"));
        customerRepository.save(new Customer("Arne", "Larsson"));
        customerRepository.save(new Customer("Lars", "Kamb"));
        customerRepository.save(new Customer("Niklas", "Cassel"));
        customerRepository.save(new Customer("Jonas", "Lindberg"));
        customerRepository.save(new Customer("Anders", "Hellström"));
    }
}
