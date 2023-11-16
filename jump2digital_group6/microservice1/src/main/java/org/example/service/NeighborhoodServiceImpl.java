package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.NeighborhoodActivity;
import org.example.repository.NeighborhoodActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NeighborhoodServiceImpl implements NeighborhoodService{
    private final NeighborhoodActivityRepository neighborhoodRepository;

    @Override
    public List<NeighborhoodActivity> getByActivity(String activity){

        List<NeighborhoodActivity> neighborhoods = neighborhoodRepository.findAll();
        return neighborhoods.stream().filter(neighborhood -> neighborhood.getNom_Grup_Activitat().equals(activity)).collect(Collectors.toList());
    }

}
