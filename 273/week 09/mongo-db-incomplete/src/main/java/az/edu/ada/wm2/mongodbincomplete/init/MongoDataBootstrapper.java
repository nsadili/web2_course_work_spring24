package az.edu.ada.wm2.mongodbincomplete.init;

import az.edu.ada.wm2.mongodbincomplete.entity.Course;
import az.edu.ada.wm2.mongodbincomplete.entity.Student;
import az.edu.ada.wm2.mongodbincomplete.repo.CourseRepository;
import az.edu.ada.wm2.mongodbincomplete.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoDataBootstrapper implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository studRepo;

    @Override
    public void run(String... args) throws Exception {
//        var c = new Course(null, "WM2", "Web and Mobile 2", null);
        var c = Course.builder()
                .shortName("WM2")
                .fullName("Web and Mobile 2")
                .build();
        var c2 = Course.builder()
                .shortName("DB")
                .fullName("DB Systems")
                .build();

        c = courseRepo.save(c);
        c2 = courseRepo.save(c2);

        System.out.println(c);
        System.out.println(c2);


        var st1 = Student.builder()
                .firstname("Nuraddin")
                .lastname("Sadili")
                .grade(3.0)
                .courses(List.of(c, c2))
                .build();

        System.out.println(
                studRepo.insert(st1)
        );

    }
}
