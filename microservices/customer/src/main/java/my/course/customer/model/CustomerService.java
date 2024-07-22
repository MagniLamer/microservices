package my.course.customer.model;

import my.course.customer.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public record CustomerService (
    CustomerRepository customerRepository
){
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();
        customerRepository.save(customer);

        //TODO: check if email is valid
        //TODO: check if email is not taken

    }
}
