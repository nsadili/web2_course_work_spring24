package az.edu.ada.wm2.workingwithrelationaldatademojpa.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findAll(Pageable pageable);

    Iterable<Student> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Student> findByFirstNameOrLastName(String firstName, String lastName);

}
