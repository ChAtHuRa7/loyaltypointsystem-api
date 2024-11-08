package com.abc.loyaltypointsystem.servicers;

import com.abc.loyaltypointsystem.dtos.AddPointRequestDto;
import com.abc.loyaltypointsystem.dtos.CustomerCreateRequestDto;
import com.abc.loyaltypointsystem.entity.Customer;
import com.abc.loyaltypointsystem.exceptions.CustomerAlreadyExistsException;
import com.abc.loyaltypointsystem.exceptions.CustomerNotFoundException;
import com.abc.loyaltypointsystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addPoints(AddPointRequestDto addPointRequestDto, long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with this Id not found."));
        customer.setPoints(customer.getPoints() + addPointRequestDto.getPoints());
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
