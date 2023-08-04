package com.flyBookingBackend.flyBookingBackend.Controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.flyBookingBackend.flyBookingBackend.DTO.UserDTO;
import com.flyBookingBackend.flyBookingBackend.Service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
      private final UserService userService;

      @Autowired
      public UserController(UserService userService) {
            this.userService = userService;

      }

      @GetMapping("/{id}")
      public UserDTO getUserById(@PathVariable BigInteger id) {

            try {
                  UserDTO result = this.userService.getUserById(id);

                  return result;

            } catch (Exception e) {
                  throw new ResponseStatusException(
                              HttpStatus.INTERNAL_SERVER_ERROR, "Su mamita hijueputa no funciona", e);
            }

      }
}
