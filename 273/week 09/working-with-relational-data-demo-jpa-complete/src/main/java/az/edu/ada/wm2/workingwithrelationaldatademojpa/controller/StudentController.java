package az.edu.ada.wm2.workingwithrelationaldatademojpa.controller;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.CourseService;
import az.edu.ada.wm2.workingwithrelationaldatademojpa.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping({"", "/", "/list"})
    public String getStudents(Model model) {
        return getStudentsByPageNo(model, 1);
    }

    @GetMapping("/page/{no}")
    public String getStudentsByPageNo(Model model, @PathVariable("no") Integer pageNo) {
        Page<Student> studentsPage = studentService.list(pageNo);

        model.addAttribute("students", studentsPage.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", studentsPage.getTotalPages());
        model.addAttribute("nbElements", studentsPage.getNumberOfElements());
        model.addAttribute("totalElements", studentsPage.getTotalElements());

        return "students/index";
    }

    @GetMapping("/new")
    public String createNewStudent(Model model) {
        model.addAttribute("student", new Student());
        LOGGER.info("createNewStudent()");
        return "students/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/";
    }

    @GetMapping("/{id}")
    public String getStudent(Model model, @PathVariable Long id) throws Exception {
        model.addAttribute("student", studentService.getById(id));
        return "students/info";
    }

    @GetMapping("/and/{firstName}/{lastName}")
    public String getStudentByNameAnd(Model model, @PathVariable String firstName, @PathVariable String lastName) {

        var student = studentService.getStudentByNamesAnd(firstName, lastName);

        model.addAttribute("students", student);

        return "students/index";
    }

    @GetMapping("/or/{firstName}/{lastName}")
    public String getStudentByNameOr(Model model, @PathVariable String firstName, @PathVariable String lastName) {
        model.addAttribute("students", studentService.getStudentByNamesOr(firstName, lastName));

        return "students/index";
    }

    @GetMapping("/{id}/courses")
    public String getCoursesByStudentId(Model model, @PathVariable Long id) {
        model.addAttribute("courses", studentService.getCoursesByStudentId(id));
        return "courses/index";
    }

    @GetMapping("/{id}/addCourse")
    public String addCoursePage(Model model, @PathVariable Long id) {

        Student stud = studentService.getById(id);
        model.addAttribute("student", stud);

        List<Course> allCourses = studentService.getCoursesByStudentIdNot(id);
        model.addAttribute("courses", allCourses);
        return "students/add_course";
    }
}
