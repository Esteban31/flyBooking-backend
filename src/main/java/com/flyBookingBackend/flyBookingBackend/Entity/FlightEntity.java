package com.flyBookingBackend.flyBookingBackend.Entity;

import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flight")
public class FlightEntity {
      @Id
      @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_flight")
      @SequenceGenerator(name = "generator_flight", schema = "flybooking", sequenceName = "seq_flight", allocationSize = 1)
      @Column(name = "id")
      private BigInteger id;

      @Column(name = "origin")
      private String origin;

      @Column(name = "destiny")
      private String destiny;

      @Column(name = "departure")
      private Date departure;

      @Column(name = "arrive")
      private Date arrive;

      @Column(name = "is_direct")
      private Boolean is_direct;

      @Column(name = "price_per_passanger")
      private Integer price_per_passanger;

      @Column(name = "price_per_child")
      private Integer price_per_child;

}
