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
public class Course {
    @Id
    private String id;
    private String shortName;
    private String fullName;

    List<Student> students;

    public Course(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Course: [" + id + ", " + shortName + ", " + fullName + "]";
    }
}
