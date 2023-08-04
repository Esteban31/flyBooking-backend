package com.flyBookingBackend.flyBookingBackend.Entity;

import java.math.BigInteger;

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
@Table(name = "user")
public class UserEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_user")
      @SequenceGenerator(name = "generator_user", schema = "flybooking", sequenceName = "seq_user", allocationSize = 1)
      @Column(name = "id")
      private BigInteger id;

      @Column(name = "email")
      private String email;

      @Column(name = "password")
      private String password;

}
