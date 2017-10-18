package site.services.interfaces;

import site.entities.Role;

public interface RoleService {
    Role findByName(String name);
}
