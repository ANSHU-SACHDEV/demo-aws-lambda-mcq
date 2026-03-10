package awslambda.example.demo.Service;

import awslambda.example.demo.Model.Question;
import awslambda.example.demo.Model.Test;
import awslambda.example.demo.Model.TestSubmissionModel;
import awslambda.example.demo.Repository.AttemptRepository;
import awslambda.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AttemptRepository attemptRepository;

    public List<Test> getTestsForStudent(String year){

        return studentRepository.getTestsForStudent(year);
    }

    public List<Question> getQuestionsByTest(int testId){

        return studentRepository.getQuestionsByTest(testId);
    }

    public int submitTest(TestSubmissionModel submission){

        List<Question> questions =
                studentRepository.getQuestionsByTest(submission.getTest_id());

        int score=0;

        for(Question q:questions){

            String studentAnswer =
                    submission.getAnswers().get(q.getQuestion_id());

            if(studentAnswer!=null &&
                    studentAnswer.equalsIgnoreCase(q.getCorrect_answer())){

                score += q.getMarks();
            }
        }

        studentRepository.saveAttempt(
                submission.getStudent_id(),
                submission.getTest_id(),
                score
        );

        return score;
    }
}