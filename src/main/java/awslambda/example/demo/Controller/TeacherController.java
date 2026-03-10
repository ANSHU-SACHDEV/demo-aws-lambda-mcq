package awslambda.example.demo.Controller;

import awslambda.example.demo.Model.Attempt;
import awslambda.example.demo.Model.Question;
import awslambda.example.demo.Model.Test;
import awslambda.example.demo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/create-test")
    public int createTest(@RequestBody Test test){

        return teacherService.createTest(test);
    }
    @PostMapping("/add-question")
    public void addQuestion(@RequestBody Question q){

        teacherService.addQuestion(q);
    }

    @GetMapping("/results")
    public List<Attempt> getResults(){

        return teacherService.viewResults();
    }

}