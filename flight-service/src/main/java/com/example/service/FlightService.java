package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Flight;


public interface FlightService {
     public Flight save(Flight flight);
     public Flight findByCode(int id);
     public List<Flight> findByCarrier(String carrier);
     public List<Flight> findByRoute(String source, String destination);
     public List<Flight> findByPriceRange(Double min, Double max);
     public List<Flight> findAll();
     public void deleteById(int id);
}
