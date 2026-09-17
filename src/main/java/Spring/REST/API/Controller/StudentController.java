package Spring.REST.API.Controller;

import java.util.List;

import Spring.REST.API.Service.StudentService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Spring.REST.API.Entity.Course;
import Spring.REST.API.Entity.Student;
import Spring.REST.API.Exceptions.CourseException;
import Spring.REST.API.Exceptions.StudentException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService ss;

    @PostMapping
    public ResponseEntity<Student> registerStudentByAdmin(@Valid @RequestBody Student student) throws StudentException {

        Student savedStudent = ss.registerStudent(student);

        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) throws StudentException {

        Student savedStudent = ss.updateStudentDetails(student);

        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudentsByNameHandler(@RequestParam("name") String name)
            throws StudentException {

        List<Student> studentsList = ss.getStudentByName(name);

        return new ResponseEntity<List<Student>>(studentsList, HttpStatus.OK);
    }

    @PostMapping("/{studentId}/{courseId}")
    public ResponseEntity<Course> leaveCourseByStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) throws CourseException, StudentException {

        Course course = ss.leaveTheCourse(courseId, studentId);

        return new ResponseEntity<Course>(course, HttpStatus.CREATED);

    }

}
