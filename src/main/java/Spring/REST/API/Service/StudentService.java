package Spring.REST.API.Service;

import java.util.List;

import Spring.REST.API.Entity.Course;
import Spring.REST.API.Entity.Student;
import Spring.REST.API.Exceptions.CourseException;
import Spring.REST.API.Exceptions.StudentException;

public interface StudentService {

    public Student registerStudent(Student student) throws StudentException;

    public List<Student> getStudentByName(String name) throws StudentException;

    public Student updateStudentDetails(Student student) throws StudentException;

    public Course leaveTheCourse(Integer courseId,Integer studentId) throws CourseException,StudentException;

}
