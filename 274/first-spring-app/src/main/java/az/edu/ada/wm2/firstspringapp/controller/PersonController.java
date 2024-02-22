package az.edu.ada.wm2.firstspringapp.controller;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private Person defaultPerson;

    private final Person secondPerson;

    private List personsList;

    @Autowired
    public PersonController(Person defaultPerson, Person secondPerson){
        this.defaultPerson = defaultPerson;
        this.secondPerson = secondPerson;

        this.personsList = new ArrayList(List.of(
                defaultPerson, secondPerson,
                new Person(1, "Ali", "Aliyev"),
                new Person(2, "Manaf", "Aghazade"),
                new Person(3, "Gultaj", "Muradova")));
    }

    @GetMapping
    public String getAllPersons(Model model){
        model.addAttribute("persons", personsList);
        return "person_list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model){
        model.addAttribute("person", defaultPerson);
        return "new_person_form";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person newPerson){
        this.personsList.add(newPerson);
        return "redirect:/persons";
    }
}
