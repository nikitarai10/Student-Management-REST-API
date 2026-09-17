package Spring.REST.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring.REST.API.Entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

    public Student findByMobileNumber(String mob);

    public List<Student> findByStudentName(String name);

}
