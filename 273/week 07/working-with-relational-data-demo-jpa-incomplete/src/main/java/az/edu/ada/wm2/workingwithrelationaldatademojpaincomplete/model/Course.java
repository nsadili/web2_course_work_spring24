package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model;

import lombok.*;

import jakarta.persistence.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COURSES")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer credits;

    @ManyToMany
    private Set<Student> students;

    public Course(String name, String description, Integer credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public Course(String name, Integer credits) {
        this(name, name, credits);
    }
}
