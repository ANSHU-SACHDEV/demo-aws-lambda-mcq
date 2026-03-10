package awslambda.example.demo.Service;

import awslambda.example.demo.Model.StudentModel;
import awslambda.example.demo.Model.TeacherModel;
import awslambda.example.demo.Repository.StudentRepository;
import awslambda.example.demo.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    public TeacherModel teacherLogin(String email,String password){

        return teacherRepository.findByEmail(email,password);
    }

    public StudentModel studentLogin(String email,String password){

        return studentRepository.login(email,password);
    }

}