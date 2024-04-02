package az.edu.ada.wm2.mongodbincomplete.init;

import az.edu.ada.wm2.mongodbincomplete.entity.Course;
import az.edu.ada.wm2.mongodbincomplete.entity.Student;
import az.edu.ada.wm2.mongodbincomplete.repo.CourseRepository;
import az.edu.ada.wm2.mongodbincomplete.repo.StudentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MongoDataBootstrapper implements CommandLineRunner {

    private final CourseRepository courseRepo;

    private final StudentRepository studentRepo;

    @Override
    public void run(String... args) throws Exception {
        courseRepo.deleteAll();
        studentRepo.deleteAll();

        init();

        studentRepo.findByFirstnameContains("ali").forEach(System.out::println);
    }

    private void init(){
        //        var c = new Course(null, "WM2", "Web and mobile 2", null);
        var c = Course.builder()
                .shortName("WM2")
                .fullName("Wb and mobile 2")
                .build();
        var c1 = Course.builder()
                .shortName("DB")
                .fullName("DB Systems").build();
        var c2 = Course.builder()
                .shortName("PP2")
                .fullName("Programming Principles 2").build();

        courseRepo.insert(c);
        courseRepo.insert(c1);
        courseRepo.insert(c2);

        var student = Student.builder()
                .firstname("Ali")
                .lastname("Aliyev")
                .grade(3.5)
                .courses(List.of(c1, c2)).build();

        var student2 = Student.builder()
                .firstname("Mikayil")
                .lastname("Aliyev")
                .grade(4.0)
                .courses(List.of(c, c2)).build();

        var student3 = Student.builder()
                .firstname("Mahammadali")
                .lastname("Valiyev")
                .grade(2.9)
                .courses(List.of(c, c1)).build();

        studentRepo.insert(student);
        studentRepo.insert(student3);
        studentRepo.insert(student2);
    }
}
