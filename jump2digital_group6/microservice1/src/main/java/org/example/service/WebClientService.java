package org.example.service;

import lombok.AllArgsConstructor;
import org.example.userDTO.CheckUserDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class WebClientService {
    private final WebClient webClient;

    public CheckUserDTO getUser(String token){
        return webClient.get()
                .uri("/project/auth/checkToken/"+token).
                header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<CheckUserDTO>() {})
                .block();

    }
}
