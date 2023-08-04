package com.flyBookingBackend.flyBookingBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.flyBookingBackend.flyBookingBackend.DTO.UserDTO;
import com.flyBookingBackend.flyBookingBackend.Service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

      private final UserService userService;

      @Autowired
      public AuthController(UserService userService) {
            this.userService = userService;

      }

      @PostMapping("/signUp")
      public UserDTO saveUser(
                  @RequestBody UserDTO userData) {

            try {
                  UserDTO userSaved = this.userService.createUser(userData);
                  if (userSaved != null) {
                        return userSaved;
                  } else {
                        return userSaved;

                  }

            } catch (Exception e) {
                  throw new ResponseStatusException(
                              HttpStatus.INTERNAL_SERVER_ERROR, "Error creating a user", e);

            }
      }


      @PostMapping("/login")
      public Boolean getUserByEmailAndPassword(@RequestBody UserDTO data) {



            String email = data.getEmail();
            String password = data.getPassword();

            try {
                  UserDTO result = this.userService.getUserByEmailAndPassword(email, password);

                  if (result.getEmail() == null) {
                        return false;
                  }else{
                        return true;
                  }


            } catch (Exception e) {
                  System.out.print(e);
                  throw new ResponseStatusException(
                              HttpStatus.INTERNAL_SERVER_ERROR, "Error geting user by email and password", e);
            }

      }
      
}