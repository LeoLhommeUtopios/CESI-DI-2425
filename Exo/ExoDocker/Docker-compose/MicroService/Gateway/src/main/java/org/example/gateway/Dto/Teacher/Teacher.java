package org.example.gateway.Dto.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gateway.Dto.Subject.SubjectDtoResponse;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private SubjectDtoResponse subject;
}
