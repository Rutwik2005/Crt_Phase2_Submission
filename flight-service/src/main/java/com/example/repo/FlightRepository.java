package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    // Find by carrier
    List<Flight> findByCarrier(String carrier);

    // Find by source and destination
    List<Flight> findBySourceAndDestination(String source, String destination);

    @Query("FROM Flight WHERE cost BETWEEN :min AND :max")
    List<Flight> findByPriceRange(@Param("min") Double min,
                                  @Param("max") Double max);
}