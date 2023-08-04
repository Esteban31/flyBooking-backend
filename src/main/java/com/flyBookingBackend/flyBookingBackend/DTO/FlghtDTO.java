package com.flyBookingBackend.flyBookingBackend.DTO;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

@Data
public class FlghtDTO {
      private BigInteger id;
      private String origin;
      private String destiny;
      private Date departure;
      private Date arrive;
      private Boolean is_direct;
      private Integer price_per_passanger;
      private Integer price_per_child;
      
}
