package az.edu.ada.wm2.workingwithrelationaldatademojpa.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.CourseRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.CourseService;
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
        return courseRepo.findAll();
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

    public List<Course> getAllWebCourses(String keyword) {
        return (List<Course>) courseRepo.getAllWebCoursesUsingJPAQuery(keyword);
    }

}
