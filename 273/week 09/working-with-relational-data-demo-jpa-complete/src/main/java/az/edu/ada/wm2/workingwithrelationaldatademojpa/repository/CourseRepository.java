package az.edu.ada.wm2.workingwithrelationaldatademojpa.repository;

import az.edu.ada.wm2.workingwithrelationaldatademojpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Iterable<Course> findByStudentsId(Long id);

    @Query("select c from Course c where c not in " +
            "(select c from Course c left join c.students std where std.id = :id)")
    Iterable<Course> findByStudentsIdNot(Long id);

    @Query("select c from Course c where lower(c.description) like %:keyword%")
    Iterable<Course> getAllWebCoursesUsingJPAQuery(@Param("keyword") String keyword);

    @Query(value = "select * from courses where description like '%Web%'",
            nativeQuery = true)
    Iterable<Course> getAllWebCoursesUsingNativeQuery();
}
