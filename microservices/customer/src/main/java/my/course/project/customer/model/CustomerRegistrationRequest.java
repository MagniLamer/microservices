package my.course.project.customer.model;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email
) {
}
