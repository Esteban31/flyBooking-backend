package com.flyBookingBackend.flyBookingBackend.Service;

import java.math.BigInteger;

import com.flyBookingBackend.flyBookingBackend.DTO.UserDTO;

public interface UserService {
      
      UserDTO createUser(UserDTO data);

      UserDTO getUserById(BigInteger id);

      UserDTO getUserByEmailAndPassword(String email, String password);

}
