package my.course.project.notification;

import my.course.project.amqp.configuration.RabbitmqMessageProducer;
import my.course.project.notification.configuration.NotificationConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
    scanBasePackages = {
        "my.course.project.amqp",
        "my.course.project.notification"}
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitmqMessageProducer messageProducer,
//                                        NotificationConfiguration configuration) {
//        return args -> {
//            messageProducer.publish(
//                "foo",
//                configuration.getInternalExchange(),
//                configuration.getInternalNotificationRoutingKey()
//            );
//        };
//    }
}
