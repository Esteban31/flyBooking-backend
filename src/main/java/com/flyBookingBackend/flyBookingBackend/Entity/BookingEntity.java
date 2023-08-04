package com.flyBookingBackend.flyBookingBackend.Entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class BookingEntity {
      @Id
      @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_booking")
      @SequenceGenerator(name = "generator_booking", schema = "flybooking", sequenceName = "seq_booking", allocationSize = 1)
      @Column(name = "id")
      private BigInteger id;

      @Column(name = "passangers")
      private Integer passangers;

      @Column(name = "children")
      private Integer children;

      @Column(name = "total_payed")
      private Integer total_payed;

      @JoinColumn(name = "user_id", referencedColumnName = "id")
      @ManyToOne(optional = false)
      private UserEntity user;


      @JoinColumn(name = "flight_id", referencedColumnName = "id")
      @ManyToOne(optional = false)
      private FlightEntity flight;

}
