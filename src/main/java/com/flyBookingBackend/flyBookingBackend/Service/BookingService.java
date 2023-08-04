package com.flyBookingBackend.flyBookingBackend.Service;


import java.math.BigInteger;

import com.flyBookingBackend.flyBookingBackend.DTO.BookingDTO;

public interface BookingService {
      
      BookingDTO createBooking(BookingDTO data);
      BookingDTO getBookingByUserId(BigInteger userId);


}
