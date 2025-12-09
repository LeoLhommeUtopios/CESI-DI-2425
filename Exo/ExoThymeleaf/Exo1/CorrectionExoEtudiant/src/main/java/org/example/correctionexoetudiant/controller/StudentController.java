package org.example.correctionexoetudiant.controller;

import org.example.correctionexoetudiant.entity.Student;
import org.example.correctionexoetudiant.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll (Model model){
        List<Student> students = service.get();
        model.addAttribute("students",students);
        return "student/studentList";
    }

    @GetMapping("get_student/{id}")
    public String getById (Model model, @PathVariable() UUID id){
        Student student = service.get(id);
        model.addAttribute("student",student);
        return "student/studentDetail";
    }

    @GetMapping("get_student")
    public String getById (Model model, @RequestParam("lastname") String lastname){
        List<Student> students = service.getByLastName(lastname);
        model.addAttribute("students",students);
        return "student/searchResult";
    }

    @GetMapping("/add")
    public String getForm(Model model){
        model.addAttribute("student",new Student());
        return "student/formulaire";
    }

    @PostMapping("/add")
    public String addStudent(Student student){
        service.create(student);
        return "redirect:/student";
    }

}
