package com.flyBookingBackend.flyBookingBackend.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flyBookingBackend.flyBookingBackend.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {
      UserEntity findByEmailAndPassword(String email, String password);

}
