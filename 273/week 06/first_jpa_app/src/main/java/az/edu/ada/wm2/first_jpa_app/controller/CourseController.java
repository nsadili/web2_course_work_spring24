package az.edu.ada.wm2.first_jpa_app.controller;

import az.edu.ada.wm2.first_jpa_app.model.Course;
import az.edu.ada.wm2.first_jpa_app.repository.CourseRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseRepository courseRepo;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseRepo.findAll());
        return "courses/list";
    }

    @GetMapping("/{id}")
    public String getCourse(@PathVariable Integer id, Model model){
        var res = courseRepo.findById(id);

        Course found = res.orElseGet(() -> new Course("No", "Course"));
        model.addAttribute("course", found);

        return "courses/info";
    }

}
