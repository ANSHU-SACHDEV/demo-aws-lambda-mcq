package awslambda.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {

    int question_id;
    int test_id;
    String question_text;
    String option_a;
    String option_b;
    String option_c;
    String option_d;
    String correct_answer;
    int marks;

}