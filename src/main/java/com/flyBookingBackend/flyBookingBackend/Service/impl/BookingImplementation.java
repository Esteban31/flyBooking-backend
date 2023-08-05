package com.flyBookingBackend.flyBookingBackend.Service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyBookingBackend.flyBookingBackend.DTO.BookingDTO;
import com.flyBookingBackend.flyBookingBackend.DTO.FlghtDTO;
import com.flyBookingBackend.flyBookingBackend.DTO.UserDTO;
import com.flyBookingBackend.flyBookingBackend.Entity.BookingEntity;
import com.flyBookingBackend.flyBookingBackend.Entity.FlightEntity;
import com.flyBookingBackend.flyBookingBackend.Entity.UserEntity;
import com.flyBookingBackend.flyBookingBackend.Repository.BookingRepository;
import com.flyBookingBackend.flyBookingBackend.Repository.FlightRepository;
import com.flyBookingBackend.flyBookingBackend.Repository.UserRepository;
import com.flyBookingBackend.flyBookingBackend.Service.BookingService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingImplementation implements BookingService {

      @Autowired
      BookingRepository bookingRepository;

      @Autowired
      UserRepository userRepository;

      @Autowired
      FlightRepository flightRepository;

      @Override
      public BookingDTO createBooking(BookingDTO data) {
            BookingEntity bookingEntity = new BookingEntity();
            bookingEntity.setPassangers(data.getPassangers());

            bookingEntity.setChildren(data.getChildren());
            bookingEntity.setTotal_payed(data.getTotal_payed());

            UserEntity userEntity = userRepository.findById(data.getUser_id()).orElse(null);
            FlightEntity flightEntity = flightRepository.findById(data.getFlight_id()).orElse(null);

            // WE CHECK IF THE USER EXIST
            if (userEntity != null) {
                  bookingEntity.setUser(userEntity);
            }

            // WE CHECK IF THE FLIGHT EXIST
            if (flightEntity != null) {
                  bookingEntity.setFlight(flightEntity);
            }

            BookingDTO bookingDTO = new BookingDTO();

            BookingEntity createdBookingEntity = this.bookingRepository.save(bookingEntity);

            bookingDTO.setPassangers(createdBookingEntity.getPassangers());

            return bookingDTO;
      }

      @Override
      public List<FlghtDTO> getBookingByUserId(BigInteger userId) {
            List<BookingEntity> bookingEntityList = this.bookingRepository.findByUser_id(userId);

            List<FlghtDTO> flightDTOList = new ArrayList<>();

            for (BookingEntity bookingEntity : bookingEntityList) {
                  BookingDTO bookingDTO = new BookingDTO();
                  bookingDTO.setChildren(bookingEntity.getChildren());

                  FlightEntity flightEntity = bookingEntity.getFlight();
                  if (flightEntity != null) {
                        BigInteger flightId = flightEntity.getId();
                        bookingDTO.setFlight_id(flightId);

                        // Get all info about the flight
                        Optional<FlightEntity> flightEntityOptional = this.flightRepository.findById(flightId);

                        if (flightEntityOptional.isPresent()) {


                              FlghtDTO flightDTO = new FlghtDTO();
                              flightDTO.setArrive(flightEntity.getArrive());
                              flightDTO.setOrigin(flightEntity.getOrigin());
                              flightDTO.setDestiny(flightEntity.getDestiny());
                              flightDTO.setDeparture(flightEntity.getDeparture());
                              flightDTO.setArrive(flightEntity.getArrive());
                              flightDTO.setIs_direct(flightEntity.getIs_direct());
                              flightDTO.setPrice_per_passanger(flightEntity.getPrice_per_passanger());
                              flightDTO.setPrice_per_child(flightEntity.getPrice_per_child());
                              flightDTO.setId(flightEntity.getId());

                              flightDTOList.add(flightDTO);

                        } else {
                              return null;
                        }
                  }

            }

            return flightDTOList;
      }

      @Override
      public BookingDTO deleteBooking(BigInteger bookingId) {
            BookingEntity bookingEntity = new BookingEntity();
            Optional<BookingEntity> optionalBooking = this.bookingRepository.findById(bookingId);
            BookingDTO bookingDTO = new BookingDTO();
            if (optionalBooking.isPresent()) {
                  bookingEntity = optionalBooking.get();
                  bookingEntity.setId(bookingId);
                  this.bookingRepository.deleteById(bookingId);
                  bookingDTO.setId(bookingId);
            }
            return bookingDTO;
      }

}
