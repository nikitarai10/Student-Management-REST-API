package Spring.REST.API.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import Spring.REST.API.Entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

    public Course findByCourseName(String courseName);

}