package org.example.gateway.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gateway.Dto.Teacher.Teacher;
import org.example.gateway.Dto.Teacher.TeacherDtoReceive;
import org.example.gateway.Tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
    @Autowired
    ObjectMapper om;

    @Value("${TEACHER_PORT}")
    public String portTeacher;

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById (@PathVariable("id") long id){
        RestClient<Teacher> teacherRestClient = new RestClient<>("http://teacher:"+ portTeacher+"/api/teacher/"+id);
        return  ResponseEntity.ok(teacherRestClient.getRequest(Teacher.class));
    }

    @PostMapping
    public ResponseEntity<Teacher> postStudent (@RequestBody TeacherDtoReceive teacherDtoReceive) throws JsonProcessingException {
        System.out.println(teacherDtoReceive);
        RestClient<Teacher> teacherRestClient = new RestClient<>("http://teacher:"+portTeacher+"/api/teacher");
        return  ResponseEntity.ok(teacherRestClient.postRequest(om.writeValueAsString(teacherDtoReceive), Teacher.class));
    }
}
