package awslambda.example.demo.Repository;

import awslambda.example.demo.Model.Question;
import awslambda.example.demo.Model.StudentModel;
import awslambda.example.demo.Model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Test> getTestsForStudent(String year){

        String sql="SELECT * FROM test WHERE year_of_study=?";

        return jdbcTemplate.query(sql,new Object[]{year},(rs,row)->{

            Test t=new Test();

            t.setTest_id(rs.getInt("test_id"));
            t.setTitle(rs.getString("title"));
            t.setTeacher_id(rs.getInt("teacher_id"));
            t.setStart_time(rs.getString("start_time"));
            t.setEnd_time(rs.getString("end_time"));
            t.setCreated_at(rs.getString("created_at"));
            t.setMax_marks(rs.getInt("max_marks"));

            return t;
        });
    }

    public List<Question> getQuestionsByTest(int testId){

        String sql="SELECT * FROM question WHERE test_id=?";

        return jdbcTemplate.query(sql,new Object[]{testId},(rs,row)->{

            Question q=new Question();

            q.setQuestion_id(rs.getInt("question_id"));
            q.setTest_id(rs.getInt("test_id"));
            q.setQuestion_text(rs.getString("question_text"));

            q.setOption_a(rs.getString("option_a"));
            q.setOption_b(rs.getString("option_b"));
            q.setOption_c(rs.getString("option_c"));
            q.setOption_d(rs.getString("option_d"));

            q.setCorrect_answer(rs.getString("correct_answer"));
            q.setMarks(rs.getInt("marks"));

            return q;
        });
    }

    public void saveAttempt(int studentId,int testId,int score){

        String sql="INSERT INTO attempt(student_id,test_id,score) VALUES(?,?,?)";

        jdbcTemplate.update(sql,studentId,testId,score);
    }



    public StudentModel login(String email,String password){

        String sql="SELECT * FROM student WHERE email=? AND password=?";

        return jdbcTemplate.queryForObject(sql,
                new Object[]{email,password},
                (rs,rowNum)->{

                    StudentModel s=new StudentModel();

                    s.setStudent_id(rs.getInt("student_id"));
                    s.setName(rs.getString("name"));
                    s.setEmail(rs.getString("email"));
                    s.setPassword(rs.getString("password"));
                    s.setPhone(rs.getString("phone"));
                    s.setYear_of_study(rs.getString("year_of_study"));

                    return s;
                });
    }

}