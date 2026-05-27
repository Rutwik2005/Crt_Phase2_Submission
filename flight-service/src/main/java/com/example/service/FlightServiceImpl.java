package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Flight;
import com.example.repo.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository repo;

    @Override
    public Flight save(Flight flight) {
        return repo.save(flight);
    }

    @Override
    public List<Flight> findByCarrier(String carrier) {
        return repo.findByCarrier(carrier);
    }

    @Override
    public List<Flight> findByRoute(String source, String destination) {
        return repo.findBySourceAndDestination(source, destination);
    }

    @Override
    public List<Flight> findByPriceRange(Double min, Double max) {
        return repo.findByPriceRange(min, max);
    }

    @Override
    public List<Flight> findAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Flight findByCode(int id) {
        return repo.findById(id).orElseThrow(() -> new com.example.exception.FlightNotFoundException("Flight not found with ID: " + id));
    }
}