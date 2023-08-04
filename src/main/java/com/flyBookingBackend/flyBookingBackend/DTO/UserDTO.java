package com.flyBookingBackend.flyBookingBackend.DTO;

import java.math.BigInteger;

import lombok.Data;

@Data
public class UserDTO {
      private BigInteger id;
      private String email;
      private String password;
}
