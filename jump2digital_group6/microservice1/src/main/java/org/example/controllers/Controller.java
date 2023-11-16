package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.exceptions.HttpException;
import org.example.service.NeighborhoodService;
import org.example.service.WebClientService;
import org.example.userDTO.CheckUserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/project/zone")
public class Controller {
    private final NeighborhoodService neighborhoodService;
    private final WebClientService userWebClientService;

    @GetMapping("{token}/getActivityByNeighborhood")
    public ResponseEntity<?> getByActivity(@RequestParam String activity, @PathVariable String token){
        try {
            CheckUserDTO userDTO = userWebClientService.getUser(token);
            return ResponseEntity.status(HttpStatus.OK).
                    body(neighborhoodService.getByActivity(activity));
        }catch(HttpException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is not valid");
        }

    }

}
