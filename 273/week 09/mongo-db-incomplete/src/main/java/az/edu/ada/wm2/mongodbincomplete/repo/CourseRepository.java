package az.edu.ada.wm2.mongodbincomplete.repo;


import az.edu.ada.wm2.mongodbincomplete.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
