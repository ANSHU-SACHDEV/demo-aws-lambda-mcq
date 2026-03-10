package awslambda.example.demo.Repository;

import awslambda.example.demo.Model.TeacherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;



    public TeacherModel findByEmail(String email,String password){
        String query="SELECT * from teacher where email=? AND password=?";
        return jdbcTemplate.queryForObject(query,
                new Object[]{email,password},
                (rs,rowNum)->{

                    TeacherModel t=new TeacherModel();

                    t.setTeacher_id(rs.getInt("teacher_id"));
                    t.setName(rs.getString("name"));
                    t.setEmail(rs.getString("email"));
                    t.setPassword(rs.getString("password"));
                    t.setPhone(rs.getString("phone"));

                    return t;
                });
    }

}

