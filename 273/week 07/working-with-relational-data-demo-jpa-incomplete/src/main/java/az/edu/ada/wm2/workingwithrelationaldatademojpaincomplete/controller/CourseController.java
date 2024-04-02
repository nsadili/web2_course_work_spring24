package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.controller;

import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping({"", "/", "/list"})
    public String getCourses(Model model) {
        List<Course> courses = courseService.list();
        model.addAttribute("courses", courses);

        LOGGER.info(courses.toString());

        return "courses/index";
    }

    @GetMapping("/new")
    public String createNewCourse(Model model) {
        model.addAttribute("course", new Course());
        return "courses/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/course/";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("course", courseService.getById(id));
        return "courses/info";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        courseService.deleteById(id);
        return "redirect:/course/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateCourse(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("courses/update");

        mv.addObject("course", courseService.getById(id));
        return mv;
    }
}
