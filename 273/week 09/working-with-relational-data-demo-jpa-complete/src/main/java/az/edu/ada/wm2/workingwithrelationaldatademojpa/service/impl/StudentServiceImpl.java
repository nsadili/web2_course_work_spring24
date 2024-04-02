package az.edu.ada.wm2.workingwithrelationaldatademojpa.service.impl;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.CourseRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.repository.StudentRepository;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepo;

    private CourseRepository courseRepo;

    public StudentServiceImpl(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public Page<Student> list(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5);
        return studentRepo.findAll(pageable);
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public List<Student> getStudentByNamesAnd(String firstName, String lastName) {
        return (List<Student>) studentRepo.findByFirstNameAndLastName(firstName, lastName);

    }

    public List<Student> getStudentByNamesOr(String firstName, String lastName) {
        return (List<Student>) studentRepo.findByFirstNameOrLastName(firstName, lastName);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long id) {
        return (List<Course>) courseRepo.findByStudentsId(id);
    }

    @Override
    public List<Course> getCoursesByStudentIdNot(Long id) {
        return (List<Course>) courseRepo.findByStudentsIdNot(id);
    }
}
