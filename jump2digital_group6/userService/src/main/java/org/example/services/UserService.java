package org.example.services;

import org.example.DTO.UserDTO;
import org.example.model.User;

public interface UserService {
    User createUser(User user);

    String login(User user);

    UserDTO checkUser(String token);
}
