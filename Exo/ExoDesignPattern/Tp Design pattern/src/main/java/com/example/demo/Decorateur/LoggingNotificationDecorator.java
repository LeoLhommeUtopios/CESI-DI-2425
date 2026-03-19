package com.example.demo.Decorateur;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingNotificationDecorator implements NotificationService {

    private final NotificationService delegate;

    public LoggingNotificationDecorator(NotificationService delegate) {
        this.delegate = delegate;
    }

    @Override
    public void send(String recipient, String subject, String body) {
        long start = System.currentTimeMillis();
        log.info("📝 [LOG] Début envoi à {}", recipient);
        delegate.send(recipient, subject, body);
        log.info("📝 [LOG] Envoi terminé en {}ms", System.currentTimeMillis() - start);
    }
}
