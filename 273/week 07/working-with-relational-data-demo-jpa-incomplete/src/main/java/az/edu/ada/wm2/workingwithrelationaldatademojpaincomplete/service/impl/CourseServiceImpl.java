package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.repository.CourseRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
//@Profile("default")
@Primary
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;

    @Override
    public List<Course> list() {
        return courseRepo.findAll();
    }

    @Override
    public Course save(Course course) {
        var res = courseRepo.save(course);
        System.out.println(res == course);
        return res;
    }

    @Override
    public Course getById(Long id) {
        var res = courseRepo.findById(id);

        return res.orElseThrow(
                () -> new RuntimeException("Course with id " + id + " is not found"));
    }

    @Override
    public void deleteById(Long id) {
        courseRepo.deleteById(id);
    }
}
