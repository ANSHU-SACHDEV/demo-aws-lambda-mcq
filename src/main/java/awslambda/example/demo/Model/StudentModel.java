package awslambda.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentModel {
    int student_id;
    String name,email,password;
    String phone;
    String year_of_study;
}
