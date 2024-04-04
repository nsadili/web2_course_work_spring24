package az.edu.ada.wm2.mongodbincomplete.repo;


import az.edu.ada.wm2.mongodbincomplete.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRepository extends MongoRepository<Student, String> {

    Iterable<Student> findByLastname(String lastName);

    @Query("{  lastname : /?0/   }")
    Iterable<Student> findByLastnameNewVersion(String lastName);

    @Query("{  'lastname' : {$regex: '(?i)?0' }  }")
    Iterable<Student> findByLastnameNewVersionWithIC(String lastName);
}
