package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service.CourseService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Profile("profile1")
public class CourseServiceImpl2 implements CourseService {

    @Override
    public List<Course> list() {
        return List.of();
    }

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public Course getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
