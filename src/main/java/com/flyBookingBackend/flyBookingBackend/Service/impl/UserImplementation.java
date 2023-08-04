package com.flyBookingBackend.flyBookingBackend.Service.impl;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyBookingBackend.flyBookingBackend.DTO.UserDTO;
import com.flyBookingBackend.flyBookingBackend.Entity.UserEntity;
import com.flyBookingBackend.flyBookingBackend.Repository.UserRepository;
import com.flyBookingBackend.flyBookingBackend.Service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserImplementation implements UserService {

      @Autowired
      UserRepository userRepository;

      @Override
      public UserDTO createUser(UserDTO data) {
            UserEntity userentity = new UserEntity();
            userentity.setEmail(data.getEmail());
            userentity.setPassword(data.getPassword());

            UserDTO userdto = new UserDTO();

            UserEntity createdUserEntity = this.userRepository.save(userentity);

            userdto.setEmail(createdUserEntity.getEmail());
            userdto.setPassword(createdUserEntity.getPassword());
            userdto.setId(createdUserEntity.getId());

            return userdto;
      }

      @Override
      public UserDTO getUserById(BigInteger id) {
            Optional<UserEntity> userEntityOptional = this.userRepository.findById(id);

            if (userEntityOptional.isPresent()) {
                  UserEntity userEntity = userEntityOptional.get();

                  UserDTO userDTO = new UserDTO();
                  userDTO.setId(userEntity.getId());
                  userDTO.setEmail(userEntity.getEmail());

                  return userDTO;
            } else {
                  return null;
            }
      }
      
      @Override
      public UserDTO getUserByEmailAndPassword(String email, String password) {

            UserEntity userEntityOptional = this.userRepository.findByEmailAndPassword(email, password);

            UserDTO userDTO = new UserDTO();
        
            if (userEntityOptional != null) {
                  userDTO.setId(userEntityOptional.getId());
                  userDTO.setEmail(userEntityOptional.getEmail());
            }
            
            return userDTO;

        }
        

}
