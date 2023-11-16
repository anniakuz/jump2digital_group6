package org.example.service;

import lombok.AllArgsConstructor;
import org.example.repository.NeighborhoodActivityRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NeighborhoodDataServiceImpl implements NeighborhoodDataService {

    private final NeighborhoodActivityRepository neighborhoodActivityRepository;


}
