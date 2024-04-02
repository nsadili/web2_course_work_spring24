package az.edu.ada.wm2.mongodbincomplete.repo;


import az.edu.ada.wm2.mongodbincomplete.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
