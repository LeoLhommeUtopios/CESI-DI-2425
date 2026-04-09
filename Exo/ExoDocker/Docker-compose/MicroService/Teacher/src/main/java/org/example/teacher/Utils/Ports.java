package org.example.teacher.Utils;

import org.springframework.beans.factory.annotation.Value;

public class Ports {
    @Value("${SUBJECT_PORT}")
    public static int portSubject;
}
