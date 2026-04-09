package org.example.classeroom.Utils;

import org.springframework.beans.factory.annotation.Value;

public class Ports {

    @Value("${STUDENT_PORT}")
    public static int portStudent;

    @Value("${TEACHER_PORT}")
    public static int portTeacher;
}
