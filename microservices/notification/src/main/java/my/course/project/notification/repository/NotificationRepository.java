package my.course.project.notification.repository;

import my.course.project.clients.notification.model.NotificationRequest;
import my.course.project.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
