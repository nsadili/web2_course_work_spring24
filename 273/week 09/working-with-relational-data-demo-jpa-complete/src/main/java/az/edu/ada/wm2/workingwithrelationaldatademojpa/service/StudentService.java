package az.edu.ada.wm2.workingwithrelationaldatademojpa.service;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Page<Student> list(int pageNo);

    Student save(Student student);

    Student getById(Long id);

    List<Student> getStudentByNamesAnd(String firstName, String lastName);

    List<Student> getStudentByNamesOr(String firstName, String lastName);

    List<Course> getCoursesByStudentId(Long id);

    List<Course> getCoursesByStudentIdNot(Long id);
}
