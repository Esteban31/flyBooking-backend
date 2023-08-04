package com.flyBookingBackend.flyBookingBackend.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flyBookingBackend.flyBookingBackend.Entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, BigInteger> {
      BookingEntity findByUser_id(BigInteger userId);
}
