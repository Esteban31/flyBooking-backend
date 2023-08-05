package com.flyBookingBackend.flyBookingBackend.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flyBookingBackend.flyBookingBackend.Entity.BookingEntity;
import com.flyBookingBackend.flyBookingBackend.Entity.FlightEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, BigInteger> {
      List<BookingEntity> findByUser_id(BigInteger userId);
}
