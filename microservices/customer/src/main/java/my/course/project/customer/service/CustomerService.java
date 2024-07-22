package my.course.project.customer.service;

import my.course.project.clients.fraud.FraudClient;
import my.course.project.clients.fraud.model.FraudCheckResponse;
import my.course.project.customer.model.Customer;
import my.course.project.customer.model.CustomerRegistrationRequest;
import my.course.project.customer.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public record CustomerService (
    CustomerRepository customerRepository,
    RestTemplate restTemplate,
    FraudClient fraudClient
){
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }



        //TODO: check if email is valid
        //TODO: check if email is not taken
        //TODO: check if fraudster
        //TODO: send a notification

    }
}
