package my.course.project.notification.service;

import java.time.LocalDateTime;
import my.course.project.clients.notification.model.NotificationRequest;
import my.course.project.notification.model.Notification;
import my.course.project.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;


@Service
public record NotificationService(NotificationRepository notificationRepository) {


    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
            Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("Andrii")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build()
        );
    }
}
