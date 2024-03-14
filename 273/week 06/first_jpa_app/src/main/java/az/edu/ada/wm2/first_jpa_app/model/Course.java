package az.edu.ada.wm2.first_jpa_app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "my_courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "c_name", columnDefinition = "VARCHAR(20)")
    private String name;
    private String deptName;

    public Course(String name, String deptName){
        this.name = name;
        this.deptName = deptName;
    }

}
