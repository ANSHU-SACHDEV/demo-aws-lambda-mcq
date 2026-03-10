package awslambda.example.demo.Service;

import awslambda.example.demo.Model.Attempt;
import awslambda.example.demo.Model.Question;
import awslambda.example.demo.Model.Test;
import awslambda.example.demo.Repository.AttemptRepository;
import awslambda.example.demo.Repository.QuestionRepository;
import awslambda.example.demo.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    AttemptRepository attemptRepository;

    @Autowired
    QuestionRepository questionRepository;

    public int createTest(Test test){

        return testRepository.createTest(test);
    }

    public int addQuestion(Question q){
//        TeacherService questionRepository;
        return questionRepository.addQuestion(q);
    }

    public List<Attempt> viewResults(){

        return attemptRepository.getAllResults();
    }

}