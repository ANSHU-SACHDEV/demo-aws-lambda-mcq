package awslambda.example.demo.Controller;

import awslambda.example.demo.Model.StudentModel;
import awslambda.example.demo.Model.TeacherModel;
import awslambda.example.demo.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/teacher-login")
    public TeacherModel teacherLogin(@RequestBody TeacherModel teacher){

        return authService.teacherLogin(
                teacher.getEmail(),
                teacher.getPassword());
    }

    @PostMapping("/student-login")
    public StudentModel studentLogin(@RequestBody StudentModel student){

        return authService.studentLogin(
                student.getEmail(),
                student.getPassword());
    }

}