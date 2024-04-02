package az.edu.ada.wm2.mongodbincomplete.repo;


import az.edu.ada.wm2.mongodbincomplete.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRepository extends MongoRepository<Student, String> {

    Iterable<Student> findByFirstname(String firstName);

    @Query("{firstname: /(a|A)li/}")
    Iterable<Student> findByFirstnameContainsAli();

    @Query("{'firstname': {$regex: '(?i)?0'}   }")
    Iterable<Student> findByFirstnameContains(String name);
}
