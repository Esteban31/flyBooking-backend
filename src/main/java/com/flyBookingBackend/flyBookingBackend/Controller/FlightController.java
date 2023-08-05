package com.flyBookingBackend.flyBookingBackend.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.flyBookingBackend.flyBookingBackend.DTO.FlghtDTO;
import com.flyBookingBackend.flyBookingBackend.DTO.UserDTO;
import com.flyBookingBackend.flyBookingBackend.Service.FlightService;
import com.flyBookingBackend.flyBookingBackend.Service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/flight")
public class FlightController {
      
      private final FlightService flightService;

      @Autowired
      public FlightController(FlightService flightService) {
            this.flightService = flightService;

      }

      @PostMapping("/search")
      public List<FlghtDTO> getFlightByFilter(@RequestBody FlghtDTO data) {
            String origin = data.getOrigin();
            String destiny = data.getDestiny();
            Date departure = data.getDeparture();
            Date arrive = data.getArrive();

            try {

                  return this.flightService.getFlightByFilter(origin, destiny, departure, arrive);

            } catch (Exception e) {
                  System.out.print(e);
                  throw new ResponseStatusException(
                              HttpStatus.INTERNAL_SERVER_ERROR, "Error geting flights", e);
            }

      }

}
