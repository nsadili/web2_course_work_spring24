package az.edu.ada.wm2.workingwithrelationaldatademojpa.model;

import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
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

    @Column(name = "desc")
    private String description;

    private Integer credits;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course(String name, String description, Integer credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public Course(String name, Integer credits) {
        this(name, name, credits);
    }

    @Override
    public String toString() {
        return "Course: " + this.name + ": " + this.description;
    }
}
