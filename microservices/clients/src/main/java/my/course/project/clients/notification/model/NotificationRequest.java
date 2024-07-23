package my.course.project.clients.notification.model;

public record NotificationRequest(
    Integer toCustomerId,
    String toCustomerEmail,
    String message
) {
}
