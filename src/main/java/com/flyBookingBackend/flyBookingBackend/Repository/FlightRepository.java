package com.flyBookingBackend.flyBookingBackend.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flyBookingBackend.flyBookingBackend.Entity.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, BigInteger> {
      List<FlightEntity> findByOriginOrDestinyOrDepartureOrArrive(String origin, String destiny, Date departure, Date arrive);
}
