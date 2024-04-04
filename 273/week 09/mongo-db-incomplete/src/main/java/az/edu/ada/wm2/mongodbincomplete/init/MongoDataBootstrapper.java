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
        studRepo.deleteAll();
        courseRepo.deleteAll();
        init();
    }

    private void init() {
//        var c = new Course(null, "WM2", "Web and Mobile 2", null);
        var c = Course.builder()
                .shortName("WM2")
                .fullName("Web and Mobile 2")
                .build();
        var c2 = Course.builder()
                .shortName("DB")
                .fullName("DB Systems")
                .build();
        var c3 = Course.builder()
                .shortName("PP2")
                .fullName("Programming Principles 2")
                .build();
        var c4 = Course.builder()
                .shortName("PP1")
                .fullName("Programming Principles 1")
                .build();

        c = courseRepo.save(c);
        c2 = courseRepo.save(c2);
        c3 = courseRepo.save(c3);
        c4 = courseRepo.save(c4);

        var st1 = studRepo.save(Student.builder()
                .firstname("Nuraddin")
                .lastname("Sadili")
                .grade(3.0)
                .courses(List.of(c, c2))
                .build());

        var st2 = studRepo.save(
                Student.builder()
                        .firstname("Murad")
                        .lastname("Ibrahimli")
                        .grade(3.54)
                        .courses(List.of(c4, c3))
                        .build()
        );

        var st3 = studRepo.save(
                Student.builder()
                        .firstname("Murad")
                        .lastname("Jafarov")
                        .grade(3.3)
                        .courses(List.of(c4, c3))
                        .build()
        );

        var st4 = studRepo.save(
                Student.builder()
                        .firstname("Kamil")
                        .lastname("Jafarov")
                        .grade(2.9)
                        .courses(List.of(c4, c3, c))
                        .build()
        );

        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);
        System.out.println(st4);

        System.out.println(studRepo.findByLastnameNewVersionWithIC("jafar"));
    }
}
