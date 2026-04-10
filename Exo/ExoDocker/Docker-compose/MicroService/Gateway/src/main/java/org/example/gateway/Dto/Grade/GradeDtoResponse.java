package org.example.gateway.Dto.Grade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gateway.Dto.Student.Student;
import org.example.gateway.Dto.Subject.SubjectDtoResponse;

import javax.security.auth.Subject;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GradeDtoResponse {
    private long id;
    private double note;
    private Student student;
    private SubjectDtoResponse subject;
}
