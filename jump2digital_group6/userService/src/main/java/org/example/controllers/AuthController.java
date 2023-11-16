package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.DTO.UserDTO;
import org.example.exceptions.HttpException;
import org.example.model.User;
import org.example.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/project/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity<?> register(@RequestBody User user) {
        User userToSave;
        try {
            userToSave = userService.createUser(user);
        } catch (HttpException ex) {
            return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userToSave);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            String token = userService.login(user);
        } catch (HttpException ex) {
            return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.login(user));

    }

    @GetMapping("/checkToken/{token}")
    public ResponseEntity<?> checkToken(@PathVariable String token) {

        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized");

        }
        UserDTO userDTO = userService.checkUser(token);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }
}
