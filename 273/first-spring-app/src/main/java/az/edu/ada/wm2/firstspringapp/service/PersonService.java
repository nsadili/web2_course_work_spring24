package az.edu.ada.wm2.firstspringapp.service;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private List<Person> persons = new ArrayList<>(List.of(
            new Person("Ali", "Aliyev"),
            new Person("Gulnara", "Azizova"),
            new Person("Murad", "Ibrahimli"),
            new Person("Laman", "Khudadatzada")
    ));

    public void addPerson(Person person){
        if(person == null) return;
        if(person.getFName() == null ||  person.getFName().isBlank() ) return;
        if(person.getLName() == null ||  person.getLName().isBlank() ) return;

        persons.add(person);
    }

    public List<Person> listPersons(){
        return persons;
    }

    public void deletePerson(Integer idx){
        if(idx == null || idx < 0 || idx >= persons.size()) return;
        persons.remove(idx.intValue());
    }

}
