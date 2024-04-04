package az.edu.ada.wm2.mongodbincomplete.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Student {

    @Id
    private String id;

    private String firstname;

    private String lastname;

    private Double grade;

    @DBRef
    private List<Course> courses;

    public Student(String firstname, String lastname, Double grade) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
    }

    public Student(String firstname, String lastname, Double grade, List<Course> courses) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student: [" + id + ", " + firstname + ", " + lastname + ", " + grade + ", " + courses + "]";
    }
}
