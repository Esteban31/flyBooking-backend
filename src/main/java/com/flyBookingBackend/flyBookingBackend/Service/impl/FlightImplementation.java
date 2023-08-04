package com.flyBookingBackend.flyBookingBackend.Service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyBookingBackend.flyBookingBackend.DTO.FlghtDTO;
import com.flyBookingBackend.flyBookingBackend.Entity.FlightEntity;
import com.flyBookingBackend.flyBookingBackend.Repository.FlightRepository;
import com.flyBookingBackend.flyBookingBackend.Service.FlightService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightImplementation implements FlightService {
      @Autowired
      FlightRepository flightRepository;

      @Override
      public List<FlghtDTO> getFlightByFilter(String origin, String destiny, Date departure, Date arrive) {

            List<FlightEntity> flightEntityList = this.flightRepository.findByOriginOrDestinyOrDepartureOrArrive(origin,
                        destiny, departure, arrive);

            List<FlghtDTO> flightDTOList = new ArrayList<FlghtDTO>();


            for (FlightEntity flightEntity : flightEntityList) {
                  FlghtDTO flightDTO = new FlghtDTO();
                  flightDTO.setOrigin(flightEntity.getOrigin());
                  flightDTO.setDestiny(flightEntity.getDestiny());
                  flightDTO.setDeparture(flightEntity.getDeparture());
                  flightDTO.setArrive(flightEntity.getArrive());
                  flightDTO.setIs_direct(flightEntity.getIs_direct());
                  flightDTO.setPrice_per_passanger(flightEntity.getPrice_per_passanger());
                  flightDTO.setPrice_per_child(flightEntity.getPrice_per_child());
                  flightDTO.setId(flightEntity.getId());

                  flightDTOList.add(flightDTO);
            }

            return flightDTOList;

      }

}
