package com.flyBookingBackend.flyBookingBackend.Service;


import java.math.BigInteger;
import java.util.List;

import com.flyBookingBackend.flyBookingBackend.DTO.BookingDTO;
import com.flyBookingBackend.flyBookingBackend.DTO.FlghtDTO;

public interface BookingService {
      
      BookingDTO createBooking(BookingDTO data);
      List<FlghtDTO> getBookingByUserId(BigInteger userId);


}
