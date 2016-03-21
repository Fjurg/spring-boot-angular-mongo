package mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerAPI {

    // TODO: Add endpoints for "add" and "delete" customers from db.

    private static final Logger log = LoggerFactory.getLogger(CustomerAPI.class);

    @Autowired
    CustomerRepository customerRepository;

    /**
     * @param firstName First Name
     * @param lastName Last Name
     * @return a specific customer
     */

    @RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET)
    public Customer getSpecificCustomer(@PathVariable String firstName, @PathVariable String lastName) {
        return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getFirstName().equalsIgnoreCase(firstName)
                        && customer.getLastName().equalsIgnoreCase(lastName))
                .findAny()
                .get();
    }

    /**
     * @returns a list of all customers stored in db
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    /**
     * Use to create testdata for mongo
     *
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
     **/
}
