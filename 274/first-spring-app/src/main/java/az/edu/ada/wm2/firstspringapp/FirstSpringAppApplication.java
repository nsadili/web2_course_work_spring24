package az.edu.ada.wm2.firstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@SpringBootApplication
@RestController("/university")
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}

//	@RequestMapping("/")
	@GetMapping("/")
	public String sayHello(){
		return  "Hi there";
	}

	@GetMapping("/students")
	public List<Person> getStudents(){
		return List.of(
				new Person("Ali", "Aliyev"),
				new Person("Tural", "Hasanov"),
				new Person("Aliya", "Huseynova")
		);
	}

}

class Person implements Serializable {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
