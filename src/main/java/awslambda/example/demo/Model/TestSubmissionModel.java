package awslambda.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TestSubmissionModel {

    int student_id;
    int test_id;
    Map<Integer,String> answers;

}