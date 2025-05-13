package co.edu.icesi.introspringboot2.service;

import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.dto.CourseWithEnrollmentCountDTO;
import co.edu.icesi.introspringboot2.entity.Course;
import co.edu.icesi.introspringboot2.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    void createCourse(CourseDTO course);
    List<CourseDTO> listCourseOfStudent(long studentId);
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(long id);
    void deleteCourse(long courseId);
    List<CourseWithEnrollmentCountDTO> getCoursesWithEnrollmentCount();
     Page<CourseDTO> searchCoursesByName(String name, int page, int size);
}
