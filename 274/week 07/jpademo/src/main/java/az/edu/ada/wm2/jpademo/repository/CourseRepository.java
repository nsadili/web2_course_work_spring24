package az.edu.ada.wm2.jpademo.repository;

import az.edu.ada.wm2.jpademo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
