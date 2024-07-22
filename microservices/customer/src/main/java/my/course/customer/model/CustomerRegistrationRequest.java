package my.course.customer.model;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email
) {
}
