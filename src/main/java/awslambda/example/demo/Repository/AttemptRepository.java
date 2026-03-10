package awslambda.example.demo.Repository;

import awslambda.example.demo.Model.Attempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttemptRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Attempt> getAllResults(){

        String sql="SELECT * FROM attempt";

        return jdbcTemplate.query(sql,(rs,rowNum)->{

            Attempt a=new Attempt();

            a.setAttempt_id(rs.getInt("attempt_id"));
            a.setStudent_id(rs.getInt("student_id"));
            a.setTest_id(rs.getInt("test_id"));
            a.setScore(rs.getInt("score"));
            a.setSubmitted_at(rs.getString("submitted_at"));

            return a;
        });
    }

}