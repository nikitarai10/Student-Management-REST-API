package Spring.REST.API.Controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Spring.REST.API.Entity.Admin;
import Spring.REST.API.Exceptions.AdminException;
import Spring.REST.API.Service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adms;

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) throws AdminException {

        Admin savedAdmin = adms.createAdmin(admin);

        return new ResponseEntity<Admin>(savedAdmin, HttpStatus.CREATED);
    }

}
