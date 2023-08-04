package com.flyBookingBackend.flyBookingBackend.Service.impl;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyBookingBackend.flyBookingBackend.DTO.BookingDTO;
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
      public BookingDTO getBookingByUserId(BigInteger userId) {

            BookingEntity bookingEntity = this.bookingRepository.findByUser_id(userId);

            BookingDTO bookingDTO = new BookingDTO();

            if (bookingEntity != null) {
                  bookingDTO.setPassangers(bookingEntity.getPassangers());
                  bookingDTO.setChildren(bookingEntity.getChildren());
                  bookingDTO.setTotal_payed(bookingEntity.getTotal_payed());
            }

            return bookingDTO;

      }

}
