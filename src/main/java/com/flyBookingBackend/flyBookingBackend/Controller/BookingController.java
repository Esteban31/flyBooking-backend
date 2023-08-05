package com.flyBookingBackend.flyBookingBackend.Controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.flyBookingBackend.flyBookingBackend.DTO.BookingDTO;
import com.flyBookingBackend.flyBookingBackend.DTO.FlghtDTO;
import com.flyBookingBackend.flyBookingBackend.DTO.UserDTO;
import com.flyBookingBackend.flyBookingBackend.Service.BookingService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/booking")
public class BookingController {
      private final BookingService bookingService;

      @Autowired
      public BookingController(BookingService bookingService) {
            this.bookingService = bookingService;

      }


      @PostMapping("/create")
      public BookingDTO createBooking(
                  @RequestBody BookingDTO bookingData) {

            try {
                  BookingDTO bookingSaved = this.bookingService.createBooking(bookingData);
                  if (bookingData != null) {
                        return bookingSaved;
                  } else {
                        return bookingSaved;

                  }

            } catch (Exception e) {
                  throw new ResponseStatusException(
                              HttpStatus.INTERNAL_SERVER_ERROR, "Error creating a Booking", e);

            }
      }


      @GetMapping("/bookings/{userId}")
      public List<FlghtDTO> getUserById(@PathVariable BigInteger userId) {

            try {

                  return this.bookingService.getBookingByUserId(userId);

            } catch (Exception e) {
                  throw new ResponseStatusException(
                              HttpStatus.INTERNAL_SERVER_ERROR, "Error geting my bookings", e);
            }

      }

      @DeleteMapping("/{id}")
      public BookingDTO deleteBooking(@PathVariable BigInteger id) {
            try {
                  return this.bookingService.deleteBooking(id);
            } catch (Exception e) {
                  throw new ResponseStatusException(
                              HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting the book", e);
            }
      }
}
