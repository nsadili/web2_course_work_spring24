package az.edu.ada.wm2.first_jpa_app;

import az.edu.ada.wm2.first_jpa_app.model.Course;
import az.edu.ada.wm2.first_jpa_app.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@SpringBootApplication
public class FirstJpaAppApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepo;

	public static void main(String[] args) {
		SpringApplication.run(FirstJpaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var res = courseRepo.saveAll(List.of(
				new Course("Network", "CS"),
				new Course("CompOrg", "CS"),
				new Course("Cyber", "IT")
		));

		res.stream().forEach(System.out::println);

	}
}
