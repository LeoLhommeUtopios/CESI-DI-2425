package com.example.demo.Decorateur;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RetryNotificationDecorator implements NotificationService {

    private static final int MAX_ATTEMPTS = 3;

    private final NotificationService delegate;

    public RetryNotificationDecorator(NotificationService delegate) {
        this.delegate = delegate;
    }

    @Override
    public void send(String recipient, String subject, String body) {
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try {
                delegate.send(recipient, subject, body);
                return; // succès, on sort
            } catch (Exception e) {
                log.warn("⚠️  Tentative {}/{} échouée pour {} : {}",
                        attempt, MAX_ATTEMPTS, recipient, e.getMessage());
                if (attempt == MAX_ATTEMPTS) {
                    throw new RuntimeException("Échec après " + MAX_ATTEMPTS + " tentatives", e);
                }
            }
        }
    }
}
