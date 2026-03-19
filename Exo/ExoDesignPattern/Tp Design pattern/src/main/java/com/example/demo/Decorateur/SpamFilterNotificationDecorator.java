package com.example.demo.Decorateur;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SpamFilterNotificationDecorator implements NotificationService {

    private static final List<String> SPAM_KEYWORDS =
            List.of("promo", "gratuit", "offre");

    private final NotificationService delegate;

    public SpamFilterNotificationDecorator(NotificationService delegate) {
        this.delegate = delegate;
    }

    @Override
    public void send(String recipient, String subject, String body) {
        String lowerSubject = subject.toLowerCase();
        boolean isSpam = SPAM_KEYWORDS.stream()
                .anyMatch(lowerSubject::contains);

        if (isSpam) {
            log.warn("🚫 Message bloqué (spam) pour {} — sujet : '{}'", recipient, subject);
            return;
        }
        delegate.send(recipient, subject, body);
    }
}