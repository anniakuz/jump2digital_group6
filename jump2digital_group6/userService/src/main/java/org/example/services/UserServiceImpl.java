package org.example.services;

import lombok.AllArgsConstructor;
import org.example.config.JwtService;
import org.example.DTO.UserDTO;
import org.example.exceptions.HttpException;
import org.example.model.Role;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        if(userRepository.getUserByName(user.getName())!=null){
            throw new HttpException(HttpStatus.BAD_REQUEST,"User with this name already exist");
        }
        User userForSave = new User(user.getName());
        userForSave.setPassword(passwordEncoder.encode(user.getPassword()));
        userForSave.setRole(Role.USER);

        return userRepository.save(userForSave);
    }

    @Override
    public String login(User user) {
        User user1 = userRepository.getUserByName(user.getName());
        if(user1==null||!passwordEncoder.matches(user.getPassword(), user1.getPassword())){
            throw new HttpException(HttpStatus.UNAUTHORIZED,"Login or password is not valid");
        }
        return jwtService.generateToken((UserDetails) user1);
    }

    @Override
    public UserDTO checkUser(String token) {
        String name = jwtService.extractUsername(token);
        User userDetails = userRepository.getUserByName(name);
        boolean isValid = jwtService.isTokenValid(token,userDetails);
        UserDTO userDTO = UserDTO.builder().id(userDetails.getId()).name(name).isTokenValid(isValid).build();

        return userDTO;
    }

}
