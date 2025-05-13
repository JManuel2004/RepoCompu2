package co.edu.icesi.introspringboot2.controller.api;

import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.dto.CourseWithEnrollmentCountDTO;
import co.edu.icesi.introspringboot2.dto.StudentDTO;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.ProfessorService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private StudentService studentService;



    // Endpoint para obtener todos los cursos con su respectivo profesor
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCoursesWithProfessorId() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @GetMapping("/{courseId}/students")
    public List<StudentDTO> getStudentsByCourse(@PathVariable long courseId) {
        var course = courseService.getCourseById(courseId);
        return studentService.getStudentsByCourse(course);
    }

    @PostMapping
    public ResponseEntity createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.createCourse(courseDTO);
        return ResponseEntity.noContent().build();
    }

     @GetMapping("/with-enrollment-count")
        public ResponseEntity<List<CourseWithEnrollmentCountDTO>> getCoursesWithEnrollmentCount() {
        List<CourseWithEnrollmentCountDTO> courses = courseService.getCoursesWithEnrollmentCount();
        return ResponseEntity.ok(courses);
    }

     @GetMapping("/search")
    public ResponseEntity<Page<CourseDTO>> searchCoursesByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<CourseDTO> courses = courseService.searchCoursesByName(name, page, size);
        return ResponseEntity.ok(courses);
    }

    


}
