package Spring.REST.API.Service;

import java.util.List;

import Spring.REST.API.Entity.Course;
import Spring.REST.API.Entity.Student;
import Spring.REST.API.Exceptions.CourseException;
import Spring.REST.API.Exceptions.StudentException;

public interface CourseService {

    public Course addCourse(Course course) throws CourseException;

    public Course assignCourseToStudent(Integer courseId,Integer studentId) throws CourseException,StudentException;

    public List<Student> getStudentsEnrolledInCourse(Integer courseId) throws CourseException;

    public List<Course> getCourseByTopic(String topic) throws CourseException;

}
