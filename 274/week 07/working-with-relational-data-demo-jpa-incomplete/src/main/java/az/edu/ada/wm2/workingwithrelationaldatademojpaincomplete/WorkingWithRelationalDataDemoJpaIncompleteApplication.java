package az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete;

import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.model.Course;
import az.edu.ada.wm2.workingwithrelationaldatademojpaincomplete.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkingWithRelationalDataDemoJpaIncompleteApplication
        implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepo;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(WorkingWithRelationalDataDemoJpaIncompleteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        courseRepo.save(
                Course.builder().
                        name("Biology")
                        .description("Biology").credits(6)
                        .build()
        );
    }
}
