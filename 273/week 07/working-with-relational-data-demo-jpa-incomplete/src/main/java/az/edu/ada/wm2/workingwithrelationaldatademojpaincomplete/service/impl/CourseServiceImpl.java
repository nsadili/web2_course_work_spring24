package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.repository.CourseRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepo;

    public CourseServiceImpl(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> list() {
        return (List<Course>) courseRepo.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course getById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        courseRepo.deleteById(id);
    }

}
