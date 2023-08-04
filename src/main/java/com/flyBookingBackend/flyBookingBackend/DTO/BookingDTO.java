package com.flyBookingBackend.flyBookingBackend.DTO;

import java.math.BigInteger;

import lombok.Data;

@Data
public class BookingDTO {
      private BigInteger id;
      private Integer passangers;
      private Integer children;
      private Integer total_payed;
      private BigInteger user_id;
      private BigInteger flight_id;

}
