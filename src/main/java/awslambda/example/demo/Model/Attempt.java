package awslambda.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attempt{

    int attempt_id;
    int student_id;
    int test_id;
    int score;
    String submitted_at;

}