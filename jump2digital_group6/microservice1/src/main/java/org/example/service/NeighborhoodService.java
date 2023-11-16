package org.example.service;

import org.example.model.NeighborhoodActivity;

import java.util.List;

public interface NeighborhoodService {
    List<NeighborhoodActivity> getByActivity(String activity);
}
