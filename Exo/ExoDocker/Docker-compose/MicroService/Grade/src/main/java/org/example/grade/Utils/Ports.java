package org.example.grade.Utils;

import org.springframework.beans.factory.annotation.Value;

public class Ports {
    @Value("${STUDENT_PORT}")
    public static int portStudent;

    @Value("${SUBJECT_PORT}")
    public static int portSubject;
}
