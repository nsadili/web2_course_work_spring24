package az.edu.ada.wm2.validationexceptiondemoincomplete.controller;

import az.edu.ada.wm2.validationexceptiondemoincomplete.entity.UserData;
import az.edu.ada.wm2.validationexceptiondemoincomplete.exceptions.UserNotFoundException;
import az.edu.ada.wm2.validationexceptiondemoincomplete.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/new")
    public String showNewPage(Model model) {
        model.addAttribute("user", new UserData());
        LOG.info("This is info log: New User form is displayed");
        LOG.debug("This is debug log: New User form is displayed");
        return "users/new";
    }

    @PostMapping("/")
    public String save(Model model, @ModelAttribute("user") @Valid UserData user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";

        userService.save(user);
//        model.addAttribute("successMessage", "User successfully saved");
        return "redirect:/user/";
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("users", userService.list());
        return "/users/index";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Long id) throws UserNotFoundException {
        model.addAttribute("users", List.of(userService.findById(id)));
        return "/users/index";
    }
}
