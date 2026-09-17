package Spring.REST.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Spring.REST.API.Entity.Admin;

public interface AdminDao extends JpaRepository<Admin, String> {

    public Admin findByUsername(String username);

}