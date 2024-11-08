package com.abc.loyaltypointsystem.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private String address;

    private int points;
}
