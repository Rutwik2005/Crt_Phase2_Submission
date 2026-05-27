package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Flight;
import com.example.service.FlightService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/flights")
public class FlightController {
	  @Autowired
	  private FlightService service;
      
	  @PostMapping("/add")
	  	  public Flight addFlight(@RequestBody Flight flight) {
		  return service.save(flight);
	  }
	  
	  @GetMapping("/{id}")
	  public Flight getFlightById(@PathVariable int id) {
		  return service.findByCode(id);
	  }
	  
	  @GetMapping("/carrier/{carrier}")
	  public List<Flight> getFlightsByCarrier(@PathVariable String carrier) {
		  return service.findByCarrier(carrier);
	  }
	  
	  @GetMapping("/route")
	  public List<Flight> getFlightsByRoute(@RequestParam String source, @RequestParam String destination) {
		  return service.findByRoute(source, destination);
	  }
	  
	  @GetMapping("/price")
	  public List<Flight> getFlightsByPriceRange(@RequestParam Double min, @RequestParam Double max) {
		  return service.findByPriceRange(min, max);
	  }
	  
	  @GetMapping
	  public List<Flight> getAllFlights() {
		  return service.findAll();
	  }
	  
	  @DeleteMapping("/{id}")
	  public void deleteFlight(@PathVariable int id) {
		  service.deleteById(id);
	  }
}
