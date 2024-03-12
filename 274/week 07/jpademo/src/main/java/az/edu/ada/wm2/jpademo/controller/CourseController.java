package az.edu.ada.wm2.jpademo.controller;

import az.edu.ada.wm2.jpademo.model.Course;
import az.edu.ada.wm2.jpademo.repository.CourseRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Data
@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseRepository courseRepo;

    @GetMapping
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepo.findAll());

        return "courses/list";
    }

}
