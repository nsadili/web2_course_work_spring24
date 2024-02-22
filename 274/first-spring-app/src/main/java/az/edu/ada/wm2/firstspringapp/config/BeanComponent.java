package az.edu.ada.wm2.firstspringapp.config;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BeanComponent {

    @Primary
    @Bean
    public Person defaultPerson(){
        return new Person(0, "Default", "Person");
    }

    @Bean
    public Person anotherPerson(){
        return new Person(0, "Another", "Person");
    }

}
