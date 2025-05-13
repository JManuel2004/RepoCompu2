package co.edu.icesi.introspringboot2.controller.api;

import co.edu.icesi.introspringboot2.dto.CourseDTO;
import co.edu.icesi.introspringboot2.dto.MessageResponse;
import co.edu.icesi.introspringboot2.dto.StudentDTO;
import co.edu.icesi.introspringboot2.service.CourseService;
import co.edu.icesi.introspringboot2.service.EnrollmentService;
import co.edu.icesi.introspringboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<MessageResponse> createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{studentId}/courses")
    public List<CourseDTO> getCoursesByStudent(@PathVariable Long studentId) {
        return courseService.listCourseOfStudent(studentId);
    }

    @PatchMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    @GetMapping("/search")
    public List<StudentDTO> searchByProgram(@RequestParam("program") String program) {
        return studentService.getByProgram(program);
    }

     @GetMapping("/paginated")
    public ResponseEntity<Page<StudentDTO>> getStudentsPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<StudentDTO> students = studentService.getStudentsPaginatedAndSorted(page, size);
        return ResponseEntity.ok(students);
    }

}
