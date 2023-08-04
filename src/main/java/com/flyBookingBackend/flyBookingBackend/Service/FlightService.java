package com.flyBookingBackend.flyBookingBackend.Service;

import java.util.Date;
import java.util.List;

import com.flyBookingBackend.flyBookingBackend.DTO.FlghtDTO;

public interface FlightService {
      List<FlghtDTO> getFlightByFilter(String origin, String destiny, Date departure, Date arrive);
}
