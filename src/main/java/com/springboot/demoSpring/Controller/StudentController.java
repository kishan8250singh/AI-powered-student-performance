package com.springboot.demoSpring.Controller;

import com.springboot.demoSpring.DTO.StudentDto;
import com.springboot.demoSpring.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // test 
    @GetMapping("/test")
     public String test() {
      return "Working fine ✅";
     }
    // 🔐 Only ADMIN can create students
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public StudentDto createStudent(@RequestBody StudentDto dto) {
        System.out.println("📩 Incoming JSON DTO: " + dto);
        return studentService.createStudent(dto);
    }
    // 🧑‍🎓 Normal users & admins can list students
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }
    // 📄 Paginated student list
    @GetMapping("/paged")
    public Page<StudentDto> getStudentsPaged(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size) {
        return studentService.getStudentsPaged(page, size);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody StudentDto dto) {
        return studentService.updateStudent(id, dto);
    }
  // only ADMIN can delete students
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student with id " + id + " deleted successfully!";
    }
    // 👀 Only ADMIN can fetch full detail (with password)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllStudents() {
        studentService.deleteAllStudents();
        return "All students deleted successfully!";
    }

}
