package Spring.REST.API.Service.Impl;

import Spring.REST.API.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Spring.REST.API.Entity.Admin;
import Spring.REST.API.Exceptions.AdminException;
import Spring.REST.API.Repository.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adm;

    @Override
    public Admin createAdmin(Admin admin) throws AdminException {

        Admin existingAdmin= adm.findByUsername(admin.getUsername());

        if(existingAdmin != null)
            throw new AdminException("Admin already registered with this username!");

        return adm.save(admin);
    }

}
