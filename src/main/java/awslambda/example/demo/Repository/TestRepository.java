package awslambda.example.demo.Repository;

import awslambda.example.demo.Model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int createTest(Test test){
        String query="INSERT INTO test(title,teacher_id,start_time,end_time,max_marks,year_of_study) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(query,
                test.getTitle(),
                test.getTeacher_id(),
                test.getStart_time(),
                test.getEnd_time(),
        test.getMax_marks(),
        test.getYear_of_study());
    }
}
