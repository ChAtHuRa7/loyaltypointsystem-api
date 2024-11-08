package com.abc.loyaltypointsystem.repository;


import com.abc.loyaltypointsystem.entity.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(@NotBlank(message = "Email is required") @Email(message = "incorrect email format") String cEmail);
}
