package com.abc.loyaltypointsystem.servicers;

import com.abc.loyaltypointsystem.dtos.CustomerCreateRequestDto;
import com.abc.loyaltypointsystem.entity.Customer;
import com.abc.loyaltypointsystem.exceptions.CustomerAlreadyExistsException;
import com.abc.loyaltypointsystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer(CustomerCreateRequestDto customerCreateRequestDto) {

        if(customerRepository.findByEmail(customerCreateRequestDto.getEmail()).isPresent()){
            throw new CustomerAlreadyExistsException("Customer with the same email already exists.");
        }

        Customer newCustomer = Customer.builder()
                .firstName(customerCreateRequestDto.getFirstName())
                .lastName(customerCreateRequestDto.getLastName())
                .email(customerCreateRequestDto.getEmail())
                .phoneNumber(customerCreateRequestDto.getPhoneNumber())
                .address(customerCreateRequestDto.getAddress())
                .points(0)
                .build();

        customerRepository.save(newCustomer);
    }
}
