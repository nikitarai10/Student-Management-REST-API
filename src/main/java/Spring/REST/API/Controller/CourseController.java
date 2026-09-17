package Spring.REST.API.Controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Spring.REST.API.Entity.Course;
import Spring.REST.API.Entity.Student;
import Spring.REST.API.Exceptions.CourseException;
import Spring.REST.API.Exceptions.StudentException;
import Spring.REST.API.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService cs;

    @PostMapping
    public ResponseEntity<Course> addNewCourse(@Valid @RequestBody Course course) throws CourseException {

        Course newCourse = cs.addCourse(course);

        return new ResponseEntity<Course>(newCourse, HttpStatus.CREATED);

    }

    @PostMapping("/{studentId}/{courseId}")
    public ResponseEntity<Course> assignCourseToStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) throws CourseException, StudentException {

        Course newCourse = cs.assignCourseToStudent(studentId, courseId);

        return new ResponseEntity<Course>(newCourse, HttpStatus.CREATED);

    }

    @GetMapping("/students/{courseId}")
    public ResponseEntity<List<Student>> getStudentsEnrolledInCourse(@PathVariable("courseId") Integer courseId) throws CourseException {

        List<Student> students = cs.getStudentsEnrolledInCourse(courseId);

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @GetMapping("/{topic}")
    public ResponseEntity<List<Course>> getCourseBytopic(@PathVariable("topic") String topic) throws CourseException {

        List<Course> courses = cs.getCourseByTopic(topic);

        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }

}
