package co.edu.icesi.introspringboot2.repository;

import co.edu.icesi.introspringboot2.dto.CourseWithEnrollmentCountDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByName(String name);
    @Query("SELECT new co.edu.icesi.introspringboot2.dto.CourseWithEnrollmentCountDTO(c.name, c.professor.name, COUNT(e)) " +
           "FROM Course c LEFT JOIN c.enrollments e " +
           "GROUP BY c.id, c.name, c.professor.name")
    List<CourseWithEnrollmentCountDTO> findCoursesWithEnrollmentCount();
      Page<Course> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
