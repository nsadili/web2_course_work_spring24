package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
