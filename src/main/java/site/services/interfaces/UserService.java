package site.services.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import site.entities.User;
import site.models.RegisterUserModel;

public interface UserService extends UserDetailsService {
    void register(RegisterUserModel registerUserModel);

    User findByName(String name);
}
