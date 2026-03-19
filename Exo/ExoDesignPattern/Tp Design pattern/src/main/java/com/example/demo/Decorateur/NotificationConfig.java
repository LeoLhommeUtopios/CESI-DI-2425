package com.example.demo.Decorateur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public NotificationService notificationService() {
        // Ordre d'appel : SpamFilter → Logging → Retry → Base
        NotificationService base    = new BaseNotificationService();
        NotificationService retry   = new RetryNotificationDecorator(base);
        NotificationService logging = new LoggingNotificationDecorator(retry);
        return new SpamFilterNotificationDecorator(logging);
    }
}

