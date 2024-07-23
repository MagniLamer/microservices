package my.course.project.notification.controler;

import lombok.extern.slf4j.Slf4j;
import my.course.project.clients.notification.model.NotificationRequest;
import my.course.project.notification.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/notification")
public record NotificationController(NotificationService notificationService) {

    @PostMapping()
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("Notification received {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
