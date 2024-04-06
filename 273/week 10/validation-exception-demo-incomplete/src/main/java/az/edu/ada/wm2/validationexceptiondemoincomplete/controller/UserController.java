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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/new")
    public String showNewPag2e(Model model) {
        LOG.info("AppLog. Show new page method started! {}", LocalDateTime.now());
        model.addAttribute("user", new UserData());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOG.info("AppLog. Show new page method ended! {}", LocalDateTime.now());
        return "users/new";
    }

    @PostMapping("/")
    public String save(Model model, @ModelAttribute("user") @Valid UserData user,
                       BindingResult bindingResult) {
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
