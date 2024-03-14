package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service;


import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> list();

    Course save(Course course);

    Course getById(Long id);

    void deleteById(Long id);

}
