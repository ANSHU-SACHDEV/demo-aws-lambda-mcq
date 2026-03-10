package awslambda.example.demo.Controller;

import awslambda.example.demo.Model.Question;
import awslambda.example.demo.Model.Test;
import awslambda.example.demo.Model.TestSubmissionModel;
import awslambda.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    // Get all tests
    @GetMapping("/tests/{year}")
    public List<Test> getTests(@PathVariable String year){

        return studentService.getTestsForStudent(year);
    }


    // Get questions of a test
    @GetMapping("/questions/{testId}")
    public List<Question> getQuestions(@PathVariable int testId){

        return studentService.getQuestionsByTest(testId);
    }


    // Submit test
    @PostMapping("/submit-test")
    public int submitTest(@RequestBody TestSubmissionModel submission){

        return studentService.submitTest(submission);
    }

}