package az.edu.ada.wm2.first_jpa_app.repository;

import az.edu.ada.wm2.first_jpa_app.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
