package az.edu.ada.wm2.firstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController // "/"
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String greetUser(){
		return "Hello there!";
	}

	@GetMapping("/persons")
	public List<String> getPersons(){
		return List.of("Ali", "Nabat", "Musa", "Zumrud");
	}

	@GetMapping("/personObject")
	public List<Person> getPersonObject(){
		return List.of(
				new Person("Nabat", "Gasimzada"),
				new Person("Ali", "Aliyev"),
				new Person("Musa", "Afandiyev")
		);
	}
}

class Person{
	private String fName;
	private String lName;

	public Person(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}
}