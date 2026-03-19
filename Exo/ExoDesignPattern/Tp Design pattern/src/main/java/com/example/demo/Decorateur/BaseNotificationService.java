package com.example.demo.Decorateur;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseNotificationService implements NotificationService {

    @Override
    public void send(String recipient, String subject, String body) {
        log.info("✉️  Envoi à {} — Sujet : '{}' — Corps : '{}'",
                recipient, subject, body);
    }
}
