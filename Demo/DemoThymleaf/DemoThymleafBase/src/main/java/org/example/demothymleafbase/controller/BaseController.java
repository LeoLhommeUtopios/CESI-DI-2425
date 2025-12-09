package org.example.demothymleafbase.controller;

import org.example.demothymleafbase.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class BaseController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/person")
    public String person (Model model){
        List<Person> personList = Arrays.asList(new Person("toto",12),new Person("titi",43));
        model.addAttribute("personList",personList);
        return "person/person";
    }

}
