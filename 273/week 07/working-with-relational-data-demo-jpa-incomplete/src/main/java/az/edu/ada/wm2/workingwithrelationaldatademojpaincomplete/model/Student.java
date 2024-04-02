package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany
    private Set<Course> courses;

}
