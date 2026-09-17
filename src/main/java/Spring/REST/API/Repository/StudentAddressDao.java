package Spring.REST.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring.REST.API.Entity.StudentAddress;

public interface StudentAddressDao extends JpaRepository<StudentAddress, String> {

}
