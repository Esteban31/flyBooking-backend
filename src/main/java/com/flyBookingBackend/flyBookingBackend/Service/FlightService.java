package com.flyBookingBackend.flyBookingBackend.Service;

import java.util.Date;

import com.flyBookingBackend.flyBookingBackend.DTO.FlghtDTO;

public interface FlightService {
      FlghtDTO getFlightByFilter(String origin, String destiny, Date departure, Date arrive);
}
