package org.example.grade.Service;

import org.example.grade.Dto.GradeDtoReceive;
import org.example.grade.Dto.GradeDtoResponse;
import org.example.grade.Dto.Student;
import org.example.grade.Dto.Subject;
import org.example.grade.Entity.Grade;
import org.example.grade.Repository.GradeRepository;
import org.example.grade.Tools.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Value("${STUDENT_PORT}")
    public String portStudent;

    @Value("${SUBJECT_PORT}")
    public String portSubject;

    public GradeDtoResponse save (GradeDtoReceive gradeDtoReceive){
        Grade grade = dtoToGrade(gradeDtoReceive);
        gradeRepository.save(grade);
        return gradeToDto(grade);
    }

    public GradeDtoResponse getById (long id){
        return gradeToDto(gradeRepository.findById(id).orElse(null));
    }

    public Grade dtoToGrade (GradeDtoReceive gradeDtoReceive){
        return new Grade(gradeDtoReceive.getNote(), gradeDtoReceive.getStudentId(), gradeDtoReceive.getSubjectId());
    }
    public GradeDtoResponse gradeToDto (Grade grade){
        RestClient<Student> studentRestClient = new RestClient<>("http://student:"+ portStudent +"/api/student/"+grade.getStudentId());
        RestClient<Subject> subjectRestClient =new RestClient<>("http://matiere:"+portSubject+"/api/subject/"+grade.getSubjectId());
        Student student = studentRestClient.getRequest(Student.class);
        Subject subject = subjectRestClient.getRequest(Subject.class);
        return new GradeDtoResponse(grade.getId(),grade.getNote(),student,subject);
    }

}
