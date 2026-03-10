package awslambda.example.demo.Repository;

import awslambda.example.demo.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addQuestion(Question q){

        String sql="INSERT INTO question(test_id,question_text,option_a,option_b,option_c,option_d,correct_answer,marks) VALUES(?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(sql,
                q.getTest_id(),
                q.getQuestion_text(),
                q.getOption_a(),
                q.getOption_b(),
                q.getOption_c(),
                q.getOption_d(),
                q.getCorrect_answer(),
                q.getMarks());
    }
}