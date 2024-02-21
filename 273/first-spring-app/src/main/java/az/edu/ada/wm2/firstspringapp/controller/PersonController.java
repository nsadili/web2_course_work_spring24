package az.edu.ada.wm2.firstspringapp.controller;

import az.edu.ada.wm2.firstspringapp.configuration.Beans;
import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

//    private Person defaultPerson = new Beans().getPersonBean();
    @Autowired
    private Person defaultPerson;

    private Person secondPerson;

    public PersonController(Person secondPerson){
        this.secondPerson = secondPerson;
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping
    public String listPersons(Model model){
        System.out.println(defaultPerson);
        System.out.println(secondPerson);
        System.out.println(defaultPerson == secondPerson);

        var list = List.of(
                new Person("Ali", "Aliyev"),
                new Person("Gulnara", "Azizova"),
                new Person("Murad", "Ibrahimli"),
                new Person("Laman", "Khudadatzada")
        );

        model.addAttribute("persons", list);
        return "person_list";
    }

}
