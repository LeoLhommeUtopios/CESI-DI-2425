package org.example.correctionexoetudiant.service;

import org.example.correctionexoetudiant.Repository.StudentRepository;
import org.example.correctionexoetudiant.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create (Student student){
        student.setId(UUID.randomUUID());
        repository.save(student);
        return student;
    }

    public Student get(UUID id){
        return  repository.findById(id).orElse(null);
    }

    public List<Student> get(){
        return repository.findAll();
    }

    public List<Student> getByLastName (String lastname){
        return repository.getStudentsByLastname(lastname);
    }
}
