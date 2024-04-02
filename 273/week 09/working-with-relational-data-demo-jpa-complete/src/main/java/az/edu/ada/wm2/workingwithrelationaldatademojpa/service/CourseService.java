package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> list();

    Course save(Course course);

    Course getById(Long id);

    void deleteById(Long id);

    List<Course> getAllWebCourses(String keyword);

//    List<Course> findByStudentsId(Long id);
}
