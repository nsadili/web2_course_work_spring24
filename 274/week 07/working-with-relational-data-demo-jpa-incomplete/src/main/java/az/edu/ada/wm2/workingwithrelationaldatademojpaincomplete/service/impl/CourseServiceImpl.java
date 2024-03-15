package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.repository.CourseRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;


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
        return courseRepo.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        courseRepo.deleteById(id);
    }
}
