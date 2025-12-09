package org.example.correctionexoetudiant.Repository;

import org.example.correctionexoetudiant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> getStudentsByLastname(String lastname);
}
