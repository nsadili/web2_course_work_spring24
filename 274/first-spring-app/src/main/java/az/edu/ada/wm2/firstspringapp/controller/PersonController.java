package az.edu.ada.wm2.firstspringapp.controller;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @GetMapping
    public String getAllPersons(Model model){
        var list = List.of(new Person(1, "Ali", "Aliyev"),
                new Person(2, "Manaf", "Aghazade"),
                new Person(3, "Gultaj", "Muradova"));

        model.addAttribute("persons", list);
        return "persons";
    }

}
