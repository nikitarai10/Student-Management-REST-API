package Spring.REST.API.Service;

import Spring.REST.API.Entity.Admin;
import Spring.REST.API.Exceptions.AdminException;

public interface AdminService {

    public Admin createAdmin(Admin admin) throws AdminException;

}
