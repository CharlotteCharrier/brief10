package fr.simplon.brief10.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;

import fr.simplon.brief10.dto.RegisterDto;
import fr.simplon.brief10.model.User;

public interface UserService {
    void saveUser(RegisterDto userMapping);

    Optional<User> from(Authentication authentication);

    Optional<User> findByUsername(String username);

}
