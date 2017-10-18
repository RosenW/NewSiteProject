package site.services.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import site.models.RegisterUserModel;

public interface UserService extends UserDetailsService {
    void register(RegisterUserModel registerUserModel);
}
