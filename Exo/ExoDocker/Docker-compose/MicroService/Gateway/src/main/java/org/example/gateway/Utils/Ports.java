package org.example.gateway.Utils;

import org.springframework.beans.factory.annotation.Value;

public class Ports {

    @Value("${STUDENT_PORT}")
    public static int portStudent;

    @Value("${TEACHER_PORT}")
    public static int portTeacher;

    @Value("${CLASSEROOM_PORT}")
    public static int portCLasseRoom;

    @Value("${GRADE_PORT}")
    public static int portGrade;

    @Value("${SUBJECT_PORT}")
    public static int portSubject;
}
