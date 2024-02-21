package az.edu.ada.wm2.firstspringapp.configuration;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Beans {

    @Bean
    @Scope("prototype")
    public Person defaultPerson(){
        return new Person("Default", "Person");
    }


}
