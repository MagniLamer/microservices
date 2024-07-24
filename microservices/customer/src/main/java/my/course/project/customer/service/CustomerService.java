package my.course.project.customer.service;

import my.course.project.amqp.configuration.RabbitmqMessageProducer;
import my.course.project.clients.fraud.FraudClient;
import my.course.project.clients.fraud.model.FraudCheckResponse;
import my.course.project.clients.notification.NotificationClient;
import my.course.project.clients.notification.model.NotificationRequest;
import my.course.project.customer.model.Customer;
import my.course.project.customer.model.CustomerRegistrationRequest;
import my.course.project.customer.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public record CustomerService(
    CustomerRepository customerRepository,
    FraudClient fraudClient,
       RabbitmqMessageProducer rabbitmqMessageProducer
) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(customer.getId(),
            customer.getEmail(),
            String.format("Hi %s, welcome", customer.getFirstName()));
        rabbitmqMessageProducer.publish(
            notificationRequest,
            "internal.exchange",
            "internal.notification.routing-key"
            );

    }
}
