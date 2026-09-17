package Spring.REST.API.Service.Impl;

import java.util.List;
import java.util.Optional;

import Spring.REST.API.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Spring.REST.API.Entity.Course;
import Spring.REST.API.Entity.Student;
import Spring.REST.API.Exceptions.CourseException;
import Spring.REST.API.Exceptions.StudentException;
import Spring.REST.API.Repository.CourseDao;
import Spring.REST.API.Repository.StudentDao;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao cd;

    @Autowired
    private StudentDao sd;

    @Override
    public Course addCourse(Course course) throws CourseException {

        Course existingCourse = cd.findByCourseName(course.getCourseName());

        if(existingCourse!=null) {
            throw new CourseException("Course is already present with this name");
        }
        return cd.save(course);
    }

    @Override
    public Course assignCourseToStudent(Integer courseId, Integer studentId) throws CourseException, StudentException {
        Optional<Student> student = sd.findById(studentId);
        Optional<Course> course = cd.findById(courseId);
        Course courseFetched = course.get();

        if(student.isPresent()) {
            Student std = student.get();
            std.getCourses().add(courseFetched);
            sd.save(std);
            courseFetched.getStudents().add(std);
        }

        return cd.save(courseFetched);
    }

    @Override
    public List<Student> getStudentsEnrolledInCourse(Integer courseId) throws CourseException {
        List<Student> students = sd.findAll();

        if(students.size()>0)
            return students;
        else
            throw new CourseException("There is no students enrolled");

    }


    @Override
    public List<Course> getCourseByTopic(String topic) throws CourseException {
        List<Course> courses = cd.findAll();

        if(courses.size()>0) {
            return courses;
        }else {
            throw new CourseException("There is no course on this topic");
        }
    }

}
